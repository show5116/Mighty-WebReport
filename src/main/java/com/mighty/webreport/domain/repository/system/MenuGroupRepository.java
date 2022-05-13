package com.mighty.webreport.domain.repository.system;

import com.mighty.webreport.domain.entity.idclass.MenuGroupId;
import com.mighty.webreport.domain.entity.system.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuGroupRepository extends JpaRepository<MenuGroup, MenuGroupId> {

}
