package com.mighty.webreport.domain.repository.jparepository;

import com.mighty.webreport.domain.entity.admin.Customer;
import com.mighty.webreport.domain.entity.idclass.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
    List<Customer> findAllByPlant(String plant);
}
