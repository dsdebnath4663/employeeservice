package com.example.employeeservice.Service;

import com.example.employeeservice.Repository.EmployeeRepository;
import com.example.employeeservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
@PostMapping
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
@GetMapping
    public Employee getEmployeeById (Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long employeeId, Employee employeeDetail){
        Employee employee = getEmployeeById(employeeId);
        System.out.println("employee details"+ employee.toString());
        {
            employee.setAge(employeeDetail.getAge());
            employee.setName(employeeDetail.getName());
            employee.setAddress(employeeDetail.getAddress());
            employee.setDepartment(employeeDetail.getDepartment());
            employee.setStatus(employeeDetail.getStatus());


        }

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
