package com.mighty.webreport.repository.jdbcrepository;

import com.mighty.webreport.domain.dto.LotNumberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LotStatusJDBCRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<LotNumberResponse> getLotNumbers(String plant)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT   LOT_NUMBER, DEVICE     ");
        sb.append("   FROM ASFC_LOT_STATUS          ");
        sb.append("  WHERE PLANT = :PLANT           ");

        SqlParameterSource namedParameters = new MapSqlParameterSource("PLANT",plant);

        RowMapper<LotNumberResponse> lotNumberResponseRowMapper = (rs, rowNum) ->{
            return LotNumberResponse.builder()
                    .id(rs.getString("lot_number"))
                    .text((rs.getString("device")))
                    .build();
        };

        return namedParameterJdbcTemplate.query(sb.toString(),namedParameters,lotNumberResponseRowMapper);
    }
}
