package com.mighty.webreport.domain.repository.admin.plant;

import com.mighty.webreport.domain.entity.admin.Plant;
import com.mighty.webreport.domain.entity.admin.QAuthorityRole;
import com.mighty.webreport.domain.entity.admin.QMember;
import com.mighty.webreport.domain.entity.admin.QPlant;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.mighty.webreport.domain.entity.admin.QAuthorityRole.authorityRole;
import static com.mighty.webreport.domain.entity.admin.QMember.member;
import static com.mighty.webreport.domain.entity.admin.QPlant.plant;

@Repository
@RequiredArgsConstructor
public class PlantRepositoryImpl implements PlantRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    /*
    SELECT a.description, A.PLANT
      FROM adm_PLANT A, adm_USER_INFO B, adm_authority_role c
     WHERE A.PLANT = b.PLANT
       AND A.PLANT = c.plant
       AND A.PLANT <> 'SYSPLANT'
       AND A.ACTIVE_PLANT = 'Y'
       AND B.USER_ID = 'S2'
       AND B.role_id = c.role_id
     ORDER BY A.PLANT
     */
    @Override
    public List<Plant> findAllByUserId(String userId) {

        String sysplant = "SYSPLANT";

        return jpaQueryFactory
                .select(plant)
                .from(plant, member, authorityRole)
                .where(member.plant.eq(plant.id)
                .and(authorityRole.plantId.eq(plant.id))
                .and(plant.id.ne(sysplant))
                .and(plant.activePlant.eq('Y'))
                .and(member.userId.eq(userId))
                .and(member.role.eq(authorityRole.roleID)))
                .orderBy(plant.id.asc())
                .fetch();
    }
}
