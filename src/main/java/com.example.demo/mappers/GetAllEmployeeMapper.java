package com.example.demo.mappers;

import com.example.demo.common.EmployeeCurrentStatus;
import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class GetAllEmployeeMapper {

    public EmployeeDTO getAllEmployees(Employee employee) {
        EmployeeDTO employeeDTO=new EmployeeDTO();
        String status= employee.getCurrentStatus();
        EmployeeCurrentStatus employeeCurrentStatus = EmployeeCurrentStatus.valueOf(status);
        employeeDTO.setEmpId(employee.getEmpId());
        employeeDTO.setEmpName(employee.getEmpName());
        employeeDTO.setEmailId(employee.getEmailId());
        employeeDTO.setCurrentStatus(employeeCurrentStatus);
        employeeDTO.setActive(employee.isActive());
        employeeDTO.setOrgId(employee.getOrg().getOrgId());
        return employeeDTO;


    }

}