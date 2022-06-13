package com.mighty.webreport.domain.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CDODto {

    private List<IdTextDto> customers;

    private List<IdTextDto> operations;

    private List<IdTextDto> devices;

    public String getCustomersString(){
        if(customers.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<customers.size(); i++){
            sb.append("'");
            sb.append(customers.get(i).getId());
            if(i==customers.size()-1){
                sb.append("' ");
            }else {
                sb.append("' ,");
            }
        }
        return sb.toString();
    }

    public String getOperationsString(){
        if(operations.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<operations.size(); i++){
            sb.append("'");
            sb.append(operations.get(i).getId());
            if(i==operations.size()-1){
                sb.append("' ");
            }else {
                sb.append("' ,");
            }
        }
        return sb.toString();
    }

    public String getDevicesString(){
        if(devices.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<devices.size(); i++){
            sb.append("'");
            sb.append(devices.get(i).getId());
            if(i==devices.size()-1){
                sb.append("' ");
            }else {
                sb.append("' ,");
            }
        }
        return sb.toString();
    }

}
