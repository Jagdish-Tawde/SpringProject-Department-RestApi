package com.tutorial.Springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.Springproject.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

     Department findBydapartmentName(String name);
}
