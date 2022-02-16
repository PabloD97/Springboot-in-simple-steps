package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.repositories.StudentRepository;
import com.springboot.universidad.universidadbackend.services.contracts.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StudentDAOImplTest {

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    StudentDAO studentDAO;

    @Test
    void searchByNameCareer() {
        studentDAO.searchByNameCareer(anyString());

        verify(studentRepository).searchByNameCareer(anyString());
    }
}