package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	public Employee getEmployeeById(long eid)
	{
		Optional<Employee> optional=emprepo.findById(eid);
		Employee employee;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee id is not found::"+eid);
		}
		return employee;
	}
	

}
