package com.example.demo.mappers;


import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.OrgService;
import org.springframework.stereotype.Component;

@Component
public class CreateEmployeeMapper {
    private final OrgService orgService;

    public CreateEmployeeMapper(OrgService orgService) {
        this.orgService = orgService;
    }

    public Employee EmployeeDtoToEmployee(EmployeeDTO employeeDto) throws ResourceNotFoundException {
            Employee employee=new Employee();
            String status=employeeDto.getCurrentStatus().toString();
            employeeDto.setEmpId(employee.getEmpId());
            employee.setEmpName(employeeDto.getEmpName());
            employee.setEmailId(employeeDto.getEmailId());
            employee.setActive(employeeDto.isActive());
            employee.setCurrentStatus(status);
            employee.setOrg(orgService.getOrgById(employeeDto.getOrgId()));
            return employee;

    }



}
