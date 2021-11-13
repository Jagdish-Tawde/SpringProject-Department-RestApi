package com.tutorial.Springproject.repository;

import com.tutorial.Springproject.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
       Department department = Department.builder()
                .departmentAddress("kan")
                .departmentName("IT")
                .departmentCode("IT-109")
                .build();
       testEntityManager.merge(department);
    }

    @Test
    public void findByDepartmentName_thenReturnDepartmentName(){

        Department department = departmentRepository.findBydepartmentName("IT").get();
        assertEquals(department.getDepartmentName(),"IT");
    }

}