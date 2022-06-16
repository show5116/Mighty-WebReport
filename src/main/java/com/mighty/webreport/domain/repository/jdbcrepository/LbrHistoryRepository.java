package com.mighty.webreport.domain.repository.jdbcrepository;

import com.mighty.webreport.domain.dto.DefectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LbrHistoryRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<DefectResponse> getDefectStatus(String plant, String startDate, String endDate, String devices, String operations, String lotNumbers){
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT c.device || ' : ' || c.description as device,");
        sql.append("       d.operation || ' : ' || d.short_desc as operation,");
        sql.append("       b.run_number,");
        sql.append("       a.lot_number,");
        sql.append("       SUM(a.lbr_qty1 - nvl(t.expand_field5, 0)) total_lbr_qty");
        sql.append("     , SUM(case when a.lbr_type = 'L' then a.lbr_qty1 else 0 end) loss_scrap_qty");
        sql.append("     , SUM(case when a.lbr_type = 'P' then a.lbr_qty1 else 0 end) loss_repair_qty");
        sql.append("     , sum(decode(ora_hash(nvl(code_group1, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP1')) || nvl(code_group2, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP2')) ||  a.lbr_code), '3008454055', lbr_qty1, 0)) as M1Scratch");
        sql.append("     , sum(decode(ora_hash(nvl(code_group1, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP1')) || nvl(code_group2, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP2')) ||  a.lbr_code), '2356725865', lbr_qty1, 0)) as Crack");
        sql.append("     , sum(decode(ora_hash(nvl(code_group1, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP1')) || nvl(code_group2, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP2')) ||  a.lbr_code), '3766372494', lbr_qty1, 0)) as Chip");
        sql.append("     , sum(decode(ora_hash(nvl(code_group1, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP1')) || nvl(code_group2, get_loss_group(a.plant, a.operation, a.lbr_code, 'CODE_GROUP2')) ||  a.lbr_code), '1176977116', lbr_qty1, 0)) as Scratch");
        sql.append(" from asfc_lbr_history a , asfc_lot_status b , adm_device c, adm_operation d,");
        sql.append("      (select a.operation, b.plant, b.table_name, b.code_name, b.code_group1, b.code_group2, b.code_group3");
        sql.append("         from adm_operation a, adm_user_code_data b");
        sql.append("        where a.plant = b.plant");
        sql.append("          and a.loss_table = b.table_name) e");
        sql.append("     , asfc_retest_history t");
        sql.append(" where a.plant = :plant");
        sql.append("   and a.plant = c.plant");
        sql.append("   and a.plant = d.plant");
        sql.append("   and a.operation = d.operation");
        sql.append("   and a.plant = e.plant(+)");
        sql.append("   and a.lbr_code = e.code_name(+)");
        sql.append("   and a.operation = e.operation(+)");
        sql.append("   and a.device = c.device");
        sql.append("   and a.lot_number = b.lot_number");
        sql.append("   and a.lbr_type in ('L', 'P')");
        sql.append("   and a.lot_number = t.lot_number(+)");
        sql.append("   and a.trans_time = t.trans_time(+)");
        sql.append("   and a.transaction = t.transaction(+)");
        sql.append("   and a.lbr_code = t.retest_code(+)");
        sql.append("   and case when t.lot_number is null then a.lbr_qty1");
        sql.append("            else t.qty1_new - t.qty1_old - nvl(t.expand_field5, 0)");
        sql.append("            end > 0");
        sql.append("   and a.trans_time >= :startDate");
        sql.append("   and a.trans_time <  :endDate");
        sql.append("   and b.create_code in ('MASS-PROD','REPAIR','RET_SHIP1','RET_SHIP2')");

        if (!operations.isEmpty()){
            sql.append("  and ( d.operation IN ( " + operations + " ) ) ");
        }

        if (!devices.isEmpty()){
            sql.append("  and ( c.device IN ( " + devices + " ) ) ");
        }

        if (!lotNumbers.isEmpty()){
            sql.append("   and a.lot_number in ( " + lotNumbers + ") ");
        }

        sql.append(" group by a.plant, c.device, c.description,  d.operation, d.short_desc  ,a.lot_number  ,b.run_number");
        sql.append(" order by 1,2,3,4");

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("plant",plant)
                .addValue("startDate",startDate)
                .addValue("endDate",endDate);

        RowMapper<DefectResponse> lotStatusMapper = (rs, rowNum) -> {
            return DefectResponse.builder()
                    .device(rs.getString("device"))
                    .operation(rs.getString("operation"))
                    .lotNumber(rs.getString("lot_number"))
                    .totalLbrQty(rs.getInt("total_lbr_qty"))
                    .lossScrapQty(rs.getInt("loss_scrap_qty"))
                    .lossRepairQty(rs.getInt("loss_repair_qty"))
                    .m1Scratch(rs.getInt("M1Scratch"))
                    .crack(rs.getInt("Crack"))
                    .chip(rs.getInt("Chip"))
                    .scratch(rs.getInt("Scratch"))
                    .build();
        };

        return namedParameterJdbcTemplate.query(sql.toString(),namedParameters,lotStatusMapper);
    }
}
