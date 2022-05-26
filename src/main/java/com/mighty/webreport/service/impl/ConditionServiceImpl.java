package com.mighty.webreport.service.impl;

import com.mighty.webreport.domain.dto.CustomerDto;
import com.mighty.webreport.domain.dto.DeviceResponse;
import com.mighty.webreport.domain.dto.OperationResponse;
import com.mighty.webreport.domain.entity.admin.Customer;
import com.mighty.webreport.domain.repository.admin.CustomerRepository;
import com.mighty.webreport.domain.repository.admin.OperationRepository;
import com.mighty.webreport.domain.repository.admin.device.DeviceRepositoryCustom;
import com.mighty.webreport.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {

    private final CustomerRepository customerRepository;

    private final OperationRepository operationRepository;

    private final DeviceRepositoryCustom deviceRepositoryCustom;

    @Override
    @Transactional(readOnly = true)
    public HashMap<String, Object> getCustomers(HashMap<String, Object> hashMap, String plant) {
        List<Customer> customers = customerRepository.findAllByPlant(plant);
        List<CustomerDto> customerDtoS = new ArrayList<>();
        for(Customer customer : customers ) {
            customerDtoS.add(customer.toDTO());
        }
        hashMap.put("customers",customerDtoS);
        return hashMap;
    }

    @Override
    @Transactional(readOnly = true)
    public HashMap<String, Object> getOperations(HashMap<String, Object> hashMap, String plant) {
        List<OperationResponse> operations = operationRepository.getOperationList(plant);
        hashMap.put("operations",operations);
        return hashMap;
    }

    @Override
    @Transactional(readOnly = true)
    public HashMap<String, Object> getDevices(HashMap<String, Object> hashMap, String plant) {
        List<DeviceResponse> devices = deviceRepositoryCustom.getDevice(plant);
        hashMap.put("devices",devices);
        return hashMap;
    }
}
