package com.example.jpademo.service;

import com.example.jpademo.domain.Employee;
import com.example.jpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee insertEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
        return employee;
    }

    public Employee deleteEmployeeById(Long id){
        Employee byId = employeeRepository.getById(id);
        employeeRepository.deleteById(byId.getId());
        return byId;
    }

    public Employee updateEmployee(Employee employee){
        Employee oldEmployee = employeeRepository.getById(employee.getId());
        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setAge(employee.getAge());
        oldEmployee.setCnp(employee.getCnp());
        employeeRepository.save(oldEmployee);
        return oldEmployee;
    }

    public Employee findById(Long id){
        return employeeRepository.getById(id);
    }

}
