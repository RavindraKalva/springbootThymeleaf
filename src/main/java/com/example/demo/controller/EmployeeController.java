package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl empservice;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees", empservice.getAllEmployees());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		empservice.saveEmployee(employee);
		return "redirect:/";
	}

}
