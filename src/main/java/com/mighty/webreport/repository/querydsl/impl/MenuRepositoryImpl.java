package com.mighty.webreport.repository.querydsl.impl;

import com.mighty.webreport.domain.dto.MenuResponse;
import com.mighty.webreport.repository.querydsl.MenuRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mighty.webreport.domain.entity.system.QMenuAction.menuAction;
import static com.mighty.webreport.domain.entity.system.QMenuStructure.menuStructure;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<MenuResponse> getMenu(String plant) {

        String moduleId = "WEBREPORT";

        return jpaQueryFactory
                .select(Projections.fields(MenuResponse.class,
                        menuStructure.menuId,
                        menuStructure.menuNameEng,
                        new CaseBuilder()
                                .when(menuAction.actionSeq.isNotNull())
                                .then("Y")
                                .otherwise("N")
                                .as("isActionMenu"),
                        new CaseBuilder()
                                .when(menuAction.actionSeq.isNotNull().and(menuStructure.menuNameKor.isNull()))
                                .then(menuAction.actionNameKor)
                                .otherwise(menuStructure.menuNameKor)
                                .as("menuNameKor"),
                        new CaseBuilder()
                                .when(menuAction.actionSeq.isNotNull().and(menuStructure.menuNameEng.isNull()))
                                .then(menuAction.actionNameEng)
                                .otherwise(menuStructure.menuNameEng)
                                .as("menuNameEng"),
                        menuStructure.hasChild,
                        menuStructure.parentKey,
                        menuStructure.displayDepth,
                        menuAction.actionSeq,
                        menuAction.action))
                .from(menuStructure)
                .leftJoin(menuAction)
                .on(menuStructure.actionSeq.eq(menuAction.actionSeq))
                .where(menuStructure.plant.eq(plant)
                .and(menuStructure.moduleId.eq(moduleId)))
                .orderBy(menuStructure.menuId.asc())
                .fetch();
    }
}
