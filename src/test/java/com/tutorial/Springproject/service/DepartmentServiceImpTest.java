package com.tutorial.Springproject.service;

import com.tutorial.Springproject.entity.Department;
import com.tutorial.Springproject.error.DepartmentNameNotFoundExceptionn;
import com.tutorial.Springproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceImpTest {

    @Autowired
    private DepartmentService service;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() throws DepartmentNameNotFoundExceptionn {
          Optional<Department> department = Optional.ofNullable(Department.builder()
                  .departmentId(1l)
                  .departmentAddress("kan")
                  .departmentName("IT")
                  .departmentCode("IT-109")
                  .build());

        Mockito.when(departmentRepository.findBydepartmentName("IT")).thenReturn( department);
    }

    @Test
    @DisplayName("Fetch DepartmentName By Name")
    void fetchDepartmentbyName() throws DepartmentNameNotFoundExceptionn {
        String departmentName ="IT";

        Department department = service.fetchDepartmentbyName(departmentName);

        assertEquals(department.getDepartmentName(),departmentName);

    }
}