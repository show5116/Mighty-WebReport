package com.mighty.webreport.service.impl;

import com.mighty.webreport.domain.dto.CustomerDto;
import com.mighty.webreport.domain.entity.admin.Customer;
import com.mighty.webreport.domain.repository.admin.customer.CustomerRepository;
import com.mighty.webreport.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {

    private final CustomerRepository customerRepository;

    @Override
    public HashMap<String, Object> getCustomers(HashMap<String, Object> hashMap, String plant) {
        List<Customer> customers = customerRepository.findAllByPlant(plant);
        List<CustomerDto> customerDtos = new ArrayList<>();
        for(Customer customer : customers ) {
            customerDtos.add(customer.toDTO());
        }
        hashMap.put("customers",customerDtos);
        return hashMap;
    }
}
