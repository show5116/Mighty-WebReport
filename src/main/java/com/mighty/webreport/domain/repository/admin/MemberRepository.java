package com.mighty.webreport.domain.repository.admin;

import com.mighty.webreport.domain.entity.admin.Member;
import com.mighty.webreport.domain.entity.idclass.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, MemberId> {
    Optional<Member> findByUserId(String userId);

    Optional<Member> findByUserIdAndPlant(String userId, String plant);
}
