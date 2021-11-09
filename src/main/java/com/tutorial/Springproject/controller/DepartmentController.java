package com.tutorial.Springproject.controller;

import java.util.List;

import com.tutorial.Springproject.error.DepartmentNameNotFoundExceptionn;
import com.tutorial.Springproject.error.DepartmentNotFoundException;
import com.tutorial.Springproject.error.NoListOfDepartmentFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.Springproject.entity.Department;
import com.tutorial.Springproject.service.DepartmentService;

import javax.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentservice;

	private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/department")
	public Department saveDepartment(@Valid  @RequestBody Department department) {
		System.out.println(department.toString());
		logger.info("Inside post request ");
		return  departmentservice.saveDepartment(department);
	}
	
	@GetMapping("/department")
	public List<Department> fethAllrecords() throws NoListOfDepartmentFoundException {
		logger.info("Inside Get request");
		return departmentservice.fethAllrecords();
	}
	
	@GetMapping("/department/{id}")
	public Department fethDepartmentbyId(@PathVariable("id") long departmentId)
			throws DepartmentNotFoundException {
		return departmentservice.fetchDepartmentbyId(departmentId);
	}
     
	@DeleteMapping("/department/{id}")
	public String deleteDepartmentById(@PathVariable("id") long departmentId) {
		departmentservice.deleteDepartmentById(departmentId);
		return "Deleted Successfully!!";
	}

	@PutMapping("/department/{id}")
	public Department upadteDepartMentByID(@PathVariable("id") long departmentId, @RequestBody Department department) {
		    
		return departmentservice.upadteDepartMentByID(departmentId , department);
		
	}

	@GetMapping("/department/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String name) throws DepartmentNameNotFoundExceptionn {
		return  departmentservice.fetchDepartmentbyName(name);
	}
	
}
