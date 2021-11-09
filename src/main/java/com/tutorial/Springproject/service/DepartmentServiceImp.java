package com.tutorial.Springproject.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.tutorial.Springproject.error.DepartmentNameNotFoundExceptionn;
import com.tutorial.Springproject.error.DepartmentNotFoundException;
import com.tutorial.Springproject.error.NoListOfDepartmentFoundException;
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
	public List<Department> fethAllrecords() throws NoListOfDepartmentFoundException {
		// TODO Auto-generated method stub
		List<Department> listOfDepartment = departmentrepository.findAll();
		if(listOfDepartment.isEmpty()){
			throw new NoListOfDepartmentFoundException("No Department is inserted as of now");
		}
		return listOfDepartment;
	}

	@Override
	public Department fetchDepartmentbyId(long departmentId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub

				Optional<Department> department = departmentrepository.findById(departmentId);
		if(!department.isPresent()){
			throw new DepartmentNotFoundException("Department Not available");
		}

		return department.get();
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
		
		if(Objects.nonNull(department.getDepartmentName())&&
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress())&&
				!"".equalsIgnoreCase(department.departmentAddress)) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode())&&
				!"".equalsIgnoreCase(department.departmentCode)) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		
		return departmentrepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentbyName(String name) throws DepartmentNameNotFoundExceptionn {
		Optional<Department> departmentByName = departmentrepository.findBydepartmentName(name);
		if(!departmentByName.isPresent()){
			throw new DepartmentNameNotFoundExceptionn("DepartmentName is not available");
		}
		return departmentByName.get();
	}


}
