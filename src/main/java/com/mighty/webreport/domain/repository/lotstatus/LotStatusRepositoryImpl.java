package com.mighty.webreport.domain.repository.lotstatus;

import com.mighty.webreport.domain.dto.LotStatusResponse;
import com.mighty.webreport.domain.entity.admin.QOperation;
import com.mighty.webreport.domain.entity.automate.QAttributeStatus;
import com.mighty.webreport.domain.entity.automate.QEquipmentLotStatus;
import com.mighty.webreport.domain.entity.automate.QLotStatus;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.util.StringUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mighty.webreport.domain.entity.admin.QOperation.operation;
import static com.mighty.webreport.domain.entity.automate.QAttributeStatus.attributeStatus;
import static com.mighty.webreport.domain.entity.automate.QEquipmentLotStatus.equipmentLotStatus;
import static com.mighty.webreport.domain.entity.automate.QLotStatus.lotStatus;

@Repository
@RequiredArgsConstructor
public class LotStatusRepositoryImpl implements LotStatusRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<LotStatusResponse> getLotStatus(String plant, String[] customers, String[] operations, String[] devices) {
        return jpaQueryFactory
                .select(Projections.fields(LotStatusResponse.class,
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(operation.operationId.concat(" : ").concat(operation.shortDesc))
                                        .from(operation)
                                        .where(operation.operationId.eq(lotStatus.operation)),
                                "operation"
                        ),
                        lotStatus.lotNumber,
                        lotStatus.mainLot,
                        lotStatus.qtyOne,
                        lotStatus.qtyUnitOne,
                        lotStatus.qtyTwo,
                        lotStatus.qtyUnitTwo,
                        lotStatus.device,
                        lotStatus.customer,
                        lotStatus.inHold,
                        lotStatus.holdNote,
                        lotStatus.inRework,
                        new CaseBuilder()
                                .when(lotStatus.processFlag.eq('Q')).then("대기")
                                .when(lotStatus.processFlag.eq('P')).then("작업")
                                .when(lotStatus.processFlag.eq('S')).then("완료대기")
                                .otherwise("?")
                                .as("processFlag"),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(attributeStatus.attributeValue)
                                        .from(attributeStatus)
                                        .where(attributeStatus.plant.eq(plant)
                                        .and(attributeStatus.lotNumber.eq(lotStatus.lotNumber))
                                        .and(attributeStatus.attributeIndex.eq(1))),
                                "deviceVer"
                        ),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(attributeStatus.attributeValue)
                                        .from(attributeStatus)
                                        .where(attributeStatus.plant.eq(plant)
                                        .and(attributeStatus.lotNumber.eq(lotStatus.lotNumber))
                                        .and(attributeStatus.attributeIndex.eq(2))),
                                "deviceAttribute"
                        ),
                        ExpressionUtils.as(
                                JPAExpressions
                                        .select(attributeStatus.attributeValue)
                                        .from(attributeStatus)
                                        .where(attributeStatus.plant.eq(plant)
                                        .and(attributeStatus.lotNumber.eq(lotStatus.lotNumber))
                                        .and(attributeStatus.attributeIndex.eq(3))),
                                "shipAttribute"
                        ),
                        lotStatus.route,
                        lotStatus.enterOperTime,
                        equipmentLotStatus.equipmentId
                ))
                .from(lotStatus)
                .leftJoin(equipmentLotStatus)
                .on(lotStatus.plant.eq(equipmentLotStatus.plant)
                .and(lotStatus.lotNumber.eq(equipmentLotStatus.lotNumber)))
                .where(eqCustomers(customers), eqOperations(operations), eqDevices(devices)
                .and(lotStatus.status.ne("99"))
                .and(lotStatus.plant.eq(plant)))
                .orderBy(Expressions.stringPath("operation").asc(),
                        lotStatus.lotNumber.asc(),
                        lotStatus.mainLot.asc(),
                        lotStatus.device.asc(),
                        lotStatus.customer.asc())
                .fetch();
    }

    private BooleanExpression eqCustomers(String[] customers){
        if(customers.length==0){
            return null;
        }
        return lotStatus.customer.in(customers);
    }

    private BooleanExpression eqOperations(String[] operations){
        if(operations.length==0){
            return null;
        }
        return lotStatus.operation.in(operations);
    }

    private BooleanExpression eqDevices(String[] devices){
        if(devices.length==0){
            return null;
        }
        return lotStatus.device.in(devices);
    }
}
