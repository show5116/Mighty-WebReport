package com.mighty.webreport.domain.repository.jdbcrepository;

import com.mighty.webreport.domain.dto.LotStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JDBCExampleRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<LotStatusResponse> getLotStatus(String plant, String customers, String operations, String devices) {
        StringBuilder sql  = new StringBuilder();

        sql.append("select   get_operation_desc(a.plant,a.operation) as operation,");
        sql.append("         a.lot_number,");
        sql.append("         a.main_lot,");
        sql.append("         a.qty1,");
        sql.append("         a.qty1_unit,");
        sql.append("         a.qty2,");
        sql.append("         a.qty2_unit,");
        sql.append("         a.device as device,");
        sql.append("         a.customer as customer,");
        sql.append("         in_hold,hold_note,");
        sql.append("         in_rework, ");
        sql.append("         case when process_flag = 'Q' then '대기' ");
        sql.append("              when process_flag = 'P' then '작업' ");
        sql.append("              when process_flag = 'S' then '완료대기' ");
        sql.append("         else '?'   ");
        sql.append("          end  as process_flag ,");
        sql.append("       (select attribute_value from asfc_attribute_status where plant = a.plant and lot_number = a.lot_number and attribute_index = 1) as device_ver,");
        sql.append("       (select attribute_value from asfc_attribute_status where plant = a.plant and lot_number = a.lot_number and attribute_index = 2) as device_attribute,");
        sql.append("       (select attribute_value from asfc_attribute_status where plant = a.plant and lot_number = a.lot_number and attribute_index = 3) as ship_attribute, ");
        sql.append("         route, ");
        sql.append("         a.enter_oper_time,");
        sql.append("         b.equipment_id ");
        sql.append(" from asfc_lot_status a,");
        sql.append("      asfc_eqplot_status b ");
        sql.append("where a.plant = :plant ");
        sql.append("  and a.plant = b.plant(+)");
        sql.append("  and a.lot_number = b.lot_number(+)");
        sql.append("  and status <> '99' ");

        if (!operations.isEmpty()){
            sql.append("  and ( a.operation IN ( " + operations + " ) ) ");
        }

        if (!devices.isEmpty()){
            sql.append("  and ( a.device IN ( " + devices + " ) ) ");
        }

        if (!customers.isEmpty()){
            sql.append("   and a.customer in ( " + customers + ") ");
        }

        sql.append("order by LENGTH(a.OPERATION), 1,2,3,8,9");

        SqlParameterSource namedParameters = new MapSqlParameterSource("plant",plant);

        RowMapper<LotStatusResponse> lotStatusMapper = (rs, rowNum) -> {
          return LotStatusResponse.builder()
                  .operation(rs.getString("operation"))
                  .lotNumber(rs.getString("lot_number"))
                  .mainLot(rs.getString("main_lot"))
                  .qtyOne(rs.getInt("qty1"))
                  .qtyUnitOne(rs.getString("qty1_unit"))
                  .qtyTwo(rs.getInt("qty2"))
                  .qtyUnitTwo(rs.getString("qty2_unit"))
                  .device(rs.getString("device"))
                  .customer(rs.getString("customer"))
                  .inHold(rs.getString("in_hold").charAt(0))
                  .holdNote(rs.getString("hold_note"))
                  .inRework(rs.getString("in_rework").charAt(0))
                  .processFlag(rs.getString("process_flag"))
                  .deviceVer(rs.getString("device_ver"))
                  .deviceAttribute(rs.getString("device_attribute"))
                  .shipAttribute(rs.getString("ship_attribute"))
                  .route(rs.getString("route"))
                  .enterOperTime(rs.getString("enter_oper_time"))
                  .equipmentId(rs.getString("equipment_id"))
                  .build();
        };

        return namedParameterJdbcTemplate.query(sql.toString(),namedParameters,lotStatusMapper);
    }
}
