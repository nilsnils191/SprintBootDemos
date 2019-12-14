package com.nilesh.demos.h2DbDemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nilesh.demos.h2DbDemo.dao.Employee;
import com.nilesh.demos.h2DbDemo.dao.EmployeeRepo;
import com.nilesh.demos.h2DbDemo.exception.NotFoundException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;

	@RequestMapping("/getById/{id}")
	public Employee getEmployeeById(@PathVariable("id") long id) throws NotFoundException {
		Optional<Employee> emp = repo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		}
		throw new NotFoundException("Employee with id "+id+" does not exist");
	}

	@RequestMapping("/getAll")
	public List<Employee> getAllEmployees() {
		Iterable<Employee> itr = repo.findAll();
		List<Employee> list = new ArrayList<Employee>();
		itr.forEach((e) -> list.add(e));
		return list;
	}

	@RequestMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return repo.save(emp);
	}

}
