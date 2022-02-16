package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.repositories.StudentRepository;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonDAOImplTest {


    PersonDAO personDAO;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        personDAO = new PersonDAOImpl(studentRepository);
    }

    @Test
    void findByNameAndLastname() {
        //when
        personDAO.findByNameAndLastname(anyString(), anyString());

        //then
        verify(studentRepository).findByNameAndLastname(anyString(),anyString());
    }

    @Test
    void findByDni() {
        //when
        personDAO.findByDni(anyString());

        //then
        verify(studentRepository).findByDni(anyString());
    }

    @Test
    void findByLastname() {
        //when
        personDAO.findByLastname(anyString());

        //then
        verify(studentRepository).findByLastname(anyString());
    }
}