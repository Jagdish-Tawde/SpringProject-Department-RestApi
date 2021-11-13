package com.tutorial.Springproject.controller;

import com.jayway.jsonpath.JsonPath;
import com.tutorial.Springproject.entity.Department;
import com.tutorial.Springproject.error.DepartmentNotFoundException;
import com.tutorial.Springproject.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentAddress("kankavali")
                .departmentName("IT")
                .departmentCode("IT-109")
                .departmentId(1l)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputdepartment = Department.builder()
                .departmentAddress("kankavali")
                .departmentName("IT")
                .departmentCode("IT-109")
                .departmentId(1l)
                .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "        \"departmentName\": \"IT\",\n" +
                        "        \"departmentAddress\": \"kankavali\",\n" +
                        "        \"departmentCode\": \"IT-109\"\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fethDepartmentbyId() throws Exception {
        Mockito.when(departmentService.fetchDepartmentbyId(1l))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
                /*.andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                            .value(department.getDepartmentName()));*/
    }
}