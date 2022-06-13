package com.mighty.webreport.domain.repository.jparepository;

import com.mighty.webreport.domain.entity.idclass.CalendarId;
import com.mighty.webreport.domain.entity.system.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, CalendarId> {
    List<Calendar> findAllByNaturalDateBetweenAndPlant(String startDate,String endDate, String plant);
}
