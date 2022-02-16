package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.data.DataDummy;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.repositories.CareerRepository;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static com.springboot.universidad.universidadbackend.data.DataDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CareerDAOImplTest {

    CareerDAO careerDAO;
    CareerRepository careerRepository;


    @BeforeEach
    void setUp(){
        careerRepository = mock(CareerRepository.class);
        careerDAO = new CareerDAOImpl(careerRepository);
    }

    @Test
    void findCareersByNameContains() {
        //Given
        String nombre = "Ingenieria";
        when(careerRepository.findCareersByNameContains(nombre))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //when
        List<Career> expect = (List<Career>) careerDAO.findCareersByNameContains(nombre);

        //then
        assertThat(expect.get(0)).isEqualTo(carrera01(true));
        assertThat(expect.get(1)).isEqualTo(carrera03(true));

        verify(careerRepository).findCareersByNameContains(nombre);
    }

    @Test
    void findCareersByNameContainsIgnoreCase() {
        //Given
        String nombre = "ingenieria";
        when(careerRepository.findCareersByNameContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //when
        List<Career> expect = (List<Career>) careerDAO.findCareersByNameContainsIgnoreCase(nombre);

        //then
        assertThat(expect.get(0)).isEqualTo(carrera01(true));
        assertThat(expect.get(1)).isEqualTo(carrera03(true));

        verify(careerRepository).findCareersByNameContainsIgnoreCase(nombre);
    }

    @Test
    void findCareersByAmountOfYearsAfter() {
        //Given
        int amountYears = 4;
        when(careerRepository.findCareersByAmountOfYearsAfter(amountYears))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //when
        List<Career> expect = (List<Career>) careerDAO.findCareersByAmountOfYearsAfter(amountYears);

        //then
        assertThat(expect.get(0)).isEqualTo(carrera01(true));
        assertThat(expect.get(1)).isEqualTo(carrera03(true));

        verify(careerRepository).findCareersByAmountOfYearsAfter(amountYears);
    }

    @Test
    void findCareersByTeachersNameAndLastname() {
        //Given

        when(careerRepository.findCareersByTeachersNameAndLastname(teacher01().getName(), teacher01().getLastname()))
                .thenReturn(Arrays.asList(carrera01(true), carrera03(true)));

        //when
        List<Career> expect = (List<Career>) careerDAO.findCareersByTeachersNameAndLastname(teacher01().getName(), teacher01().getLastname());

        //then
        assertThat(expect.get(0)).isEqualTo(carrera01(true));
        assertThat(expect.get(1)).isEqualTo(carrera03(true));

        verify(careerRepository).findCareersByTeachersNameAndLastname(teacher01().getName(), teacher01().getLastname());

    }
}