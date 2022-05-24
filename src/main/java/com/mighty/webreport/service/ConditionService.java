package com.mighty.webreport.service;

import java.util.HashMap;

public interface ConditionService {
    public HashMap<String,Object> getCustomers( HashMap<String,Object> hashMap , String plant);
    public HashMap<String,Object> getOperations( HashMap<String,Object> hashMap , String plant);

    public HashMap<String,Object> getDevices( HashMap<String,Object> hashMap , String plant);
}
