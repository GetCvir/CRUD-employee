package com.spring.mvc_hibernate_aop.controller;

import com.spring.mvc_hibernate_aop.entity.Employee;
import com.spring.mvc_hibernate_aop.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private EmpService employeeDAO;

    @RequestMapping("/")
    public String showAllEmployee(Model model){
        List<Employee> allEmployees= employeeDAO.getAllEmployees();
        model.addAttribute("allEmps",allEmployees);
        return "all-employees";
    }

    @RequestMapping("/AddNewEmployee")
    public String addNewEmp(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmp(@ModelAttribute("employee")Employee employee){
        employeeDAO.saveEmployee(employee);

        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateEmp(@RequestParam("empId")int id, Model model){
        Employee employee=employeeDAO.getEmployee(id);

        model.addAttribute("employee",employee);

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId")int id){
        Employee employee= employeeDAO.getEmployee(id);
        employeeDAO.deleteEmployee(employee);

        return "redirect:/";
    }
}
