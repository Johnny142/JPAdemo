package com.example.jpademo.controller;

import com.example.jpademo.domain.Employee;
import com.example.jpademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
    }

    @PostMapping("/employee")
    public ResponseEntity insertEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.insertEmployee(employee));
    }

    @DeleteMapping("/employee")
    public ResponseEntity deleteEmployee(@RequestParam("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployeeById(id));
    }

    @PutMapping("/employee")
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee));
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity getById(@PathVariable("empId") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
    }
}
