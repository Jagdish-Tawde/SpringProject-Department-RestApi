package com.tutorial.Springproject.service;

import java.util.List;

import com.tutorial.Springproject.entity.Department;
import com.tutorial.Springproject.error.DepartmentNameNotFoundExceptionn;
import com.tutorial.Springproject.error.DepartmentNotFoundException;
import com.tutorial.Springproject.error.NoListOfDepartmentFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fethAllrecords() throws NoListOfDepartmentFoundException;

	public Department fetchDepartmentbyId(long departmentId) throws DepartmentNotFoundException;
    
	public void deleteDepartmentById(long departmentId);

	public Department upadteDepartMentByID(long departmentId, Department department);

    public Department fetchDepartmentbyName(String name) throws DepartmentNameNotFoundExceptionn;
}
