package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository emprepo;
	@Override
	public List<Employee> getAllEmployees() {
		
		
		return emprepo.findAll();
		
	}
	public void saveEmployee(Employee emp)
	{
		emprepo.save(emp);
	}

}
