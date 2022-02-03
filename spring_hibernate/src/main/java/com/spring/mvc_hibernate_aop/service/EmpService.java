package com.spring.mvc_hibernate_aop.service;

import com.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmpService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(Employee employee);
}
