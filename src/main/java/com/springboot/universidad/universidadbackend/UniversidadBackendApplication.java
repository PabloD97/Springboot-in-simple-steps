package com.springboot.universidad.universidadbackend;

import com.springboot.universidad.universidadbackend.model.entities.Direction;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Student;
import com.springboot.universidad.universidadbackend.services.contracts.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UniversidadBackendApplication {


	public static void main(String[] args) {
		String[] beandefinitions = SpringApplication.run(UniversidadBackendApplication.class, args).getBeanDefinitionNames();
//		for (String str: beandefinitions){
//			System.out.println(str);
//		}
	}


}
