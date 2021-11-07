package com.tutorial.Springproject.controller;

import java.util.List;

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
	
	
	@PostMapping("/department")
	public Department saveDepartment(@Valid  @RequestBody Department department) {
		System.out.println(department.toString());
		return  departmentservice.saveDepartment(department);
	}
	
	@GetMapping("/department")
	public List<Department> fethAllrecords(){
		return departmentservice.fethAllrecords();
	}
	
	@GetMapping("/department/{id}")
	public Department fethDepartmentbyId(@PathVariable("id") long departmentId) {
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
	public Department getDepartmentByName(@PathVariable("name") String name){
		return  departmentservice.fetchDepartmentbyName(name);
	}
	
}
