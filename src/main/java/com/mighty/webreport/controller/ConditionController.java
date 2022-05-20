package com.mighty.webreport.controller;

import com.mighty.webreport.domain.entity.admin.Customer;
import com.mighty.webreport.domain.repository.admin.customer.CustomerRepository;
import com.mighty.webreport.security.AccountContext;
import com.mighty.webreport.security.CurrentUser;
import com.mighty.webreport.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/condition")
public class ConditionController {

    private final ConditionService conditionService;

    @GetMapping("/customerAndOperationAndDevice")
    public ResponseEntity<?> getCustomerAndOperationAndDevice(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountContext accountContext = (AccountContext) authentication.getPrincipal();
        HashMap<String, Object> hashMap = new HashMap<>();
        conditionService.getCustomers(hashMap,accountContext.getPlant());
        return ResponseEntity.ok(hashMap);
    }

}
