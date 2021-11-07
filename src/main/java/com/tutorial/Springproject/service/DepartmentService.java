package com.tutorial.Springproject.service;

import java.util.List;

import com.tutorial.Springproject.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fethAllrecords();

	public Department fetchDepartmentbyId(long departmentId);
    
	public void deleteDepartmentById(long departmentId);

	public Department upadteDepartMentByID(long departmentId, Department department);

    public Department fetchDepartmentbyName(String name);
}
