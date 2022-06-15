package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
