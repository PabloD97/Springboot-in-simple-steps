package com.springboot.universidad.universidadbackend.data;

import com.springboot.universidad.universidadbackend.model.entities.*;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;

import java.math.BigDecimal;

public class DataDummy {

    public static Career carrera01(boolean withId){
        Career career = (withId) ? new Career(1, "Ingenieria en Sistemas", 50, 5) :
                new Career(null, "Ingenieria en Sistemas", 50, 5);
        return career;
    }

    public static Career carrera02(){
        return new Career(null, "Licenciatura en Sistemas", 45, 4);
    }


    public static Career carrera03(boolean withId){
        Career career = (withId) ? new Career(3, "Ingenieria Industrial", 60, 6) :
                new Career(null, "Ingenieria Industrial", 60, 6);
        return career;
    }

    public static Teacher teacher01(){
        Direction directionTeacher01 = new Direction("Calle teacher", "442", "1888", "Department techer", "nn", "Zona Sur");
        Teacher teacher = new Teacher(null,"Teacher1","NN","40651209",directionTeacher01,new BigDecimal("4000"));
        return teacher;
    }

    public static Person employee01(){
        Direction directionTeacher01 = new Direction("Calle employee", "442", "1888", "Department employee01", "nn", "Zona Sur");
        Person employee01 = new Employee(null,"Teacher1","NN","40651210",directionTeacher01,new BigDecimal("4000"), TypeEmployee.ADMINISTRATIVE);
        return employee01;
    }

    public static Person employee02(){
        Direction directionTeacher01 = new Direction("Calle employee02", "442", "1888", "Department employee02", "nn", "Zona Sur");
        Person employee02 = new Employee(null,"Employee02","NN","40651211",directionTeacher01,new BigDecimal("4000"), TypeEmployee.MAINTENANCE);
        return employee02;
    }

    public  static Person student01(){
        return new Student(null, "Pablo", "Diaz", "45651209",new Direction());
    }

    public  static Person student02(){
        return new Student(null, "Damian", "Diaz", "45651210",new Direction());
    }
    public  static Person student03(){
        return new Student(null, "Pablini", "Diaz", "45651211",new Direction());
    }
}
