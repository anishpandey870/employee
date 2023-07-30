package com.company.service;

import com.company.entity.Employee;
import com.company.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpRepository repository;
    public Employee saveEmp(Employee employee){
        return  repository.save(employee);
    }
    public List<Employee> saveEmps(List<Employee> employees){
        return  repository.saveAll(employees);
    }
    public List<Employee> getEmps(){
      return   repository.findAll();
    }
    public Employee getEmpById(long id){
        return repository.findById(id).orElse(null);
    }
    public String deleteEmp(long id){
        repository.deleteById(id);
        return "employee delete :"+ id;
    }
    public Employee updateEmp(Employee employee){
        Employee existingEmp = repository.findById(employee.getId()).orElse(null);
        existingEmp.setName(employee.getName());
        existingEmp.setAddress(employee.getAddress());
        existingEmp.setSalary(employee.getSalary());
        return repository.save(existingEmp);
    }
}
