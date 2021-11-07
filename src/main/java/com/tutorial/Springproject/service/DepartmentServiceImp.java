package com.tutorial.Springproject.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.Springproject.entity.Department;
import com.tutorial.Springproject.repository.DepartmentRepository;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	DepartmentRepository departmentrepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentrepository.save(department);
	}

	@Override
	public List<Department> fethAllrecords() {
		// TODO Auto-generated method stub
		return departmentrepository.findAll();
	}

	@Override
	public Department fetchDepartmentbyId(long departmentId) {
		// TODO Auto-generated method stub
		return departmentrepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(long departmentId) {
		// TODO Auto-generated method stub
		departmentrepository.deleteById(departmentId);
	}
     
	
	@Override
	public Department upadteDepartMentByID(long departmentId, Department department) {
		// TODO Auto-generated method stub
		Department depDB = departmentrepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDapartmentName())&&
				!"".equalsIgnoreCase(department.getDapartmentName())) {
			depDB.setDapartmentName(department.getDapartmentName());
		}
		
		if(Objects.nonNull(department.getDapartmentAddress())&&
				!"".equalsIgnoreCase(department.dapartmentAddress)) {
			depDB.setDapartmentAddress(department.getDapartmentAddress());
		}
		
		if(Objects.nonNull(department.getDapartmentCode())&&
				!"".equalsIgnoreCase(department.dapartmentCode)) {
			depDB.setDapartmentCode(department.getDapartmentCode());
		}
		
		
		return departmentrepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentbyName(String name) {
		return departmentrepository.findBydapartmentName(name);
	}


}
