package com.company.controller;

import com.company.entity.Employee;
import com.company.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
   private EmpService service;
    @PostMapping("/add")
    public Employee addEmp(@RequestBody Employee employee){
        return service.saveEmp(employee);
    }
    @PostMapping("/addEmps")
    public List<Employee> addEmps(@RequestBody List<Employee> employees){
        return service.saveEmps(employees);
    }
   @GetMapping("/emp")
   public List<Employee> findAllEmps(){
        return service.getEmps();
   }
   @GetMapping("/emp/{id}")
    public Employee findEmpById(@PathVariable long id){
          return service.getEmpById(id);
    }
    @PutMapping("/update")
    public Employee updateEmp(@RequestBody Employee employee){
        return service.updateEmp(employee);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmp(@PathVariable long id){
        return service.deleteEmp(id);
    }



}
