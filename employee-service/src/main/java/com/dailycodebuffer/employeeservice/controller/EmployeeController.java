package com.dailycodebuffer.employeeservice.controller;


import com.dailycodebuffer.employeeservice.model.Employee;
import com.dailycodebuffer.employeeservice.repository.EmployeeRepository;
import com.dailycodebuffer.employeeservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository repository;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/{name}/salary")
    public ResponseEntity<String> getEmployeeSalary(@PathVariable String name) {

        String salaryResponse=employeeService.getSalary(name);

        if(salaryResponse==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        return ResponseEntity.ok(salaryResponse)    ;
    }

    @GetMapping("/salary")
    public void getEmployeeSalary() {
        System.out.println("I have reached here");

    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }

   /* @GetMapping("/{employeeId}/salary")
    public double getSalary(@PathVariable int employeeId) {
        return employeeService.getEmployeeSalary(employeeId);

    }*/


}
