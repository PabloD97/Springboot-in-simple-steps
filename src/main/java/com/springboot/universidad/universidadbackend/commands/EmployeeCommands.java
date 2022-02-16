package com.springboot.universidad.universidadbackend.commands;

import com.springboot.universidad.universidadbackend.model.entities.Direction;
import com.springboot.universidad.universidadbackend.model.entities.Employee;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;
import com.springboot.universidad.universidadbackend.repositories.EmployeeRepository;
import com.springboot.universidad.universidadbackend.services.contracts.EmployeeDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmployeeCommands implements CommandLineRunner {

    @Autowired
    @Qualifier("employeeDAOImpl")
    private PersonDAO personDAO;

    @Override
    public void run(String... args) throws Exception {
    /*
        Direction direction = new Direction("calle 554", "712", "1888", "Sucio", "14", "FV");
        Person employee1 = new Employee(null, "gil","laburante","12345890",direction,new BigDecimal("400"), TypeEmployee.MAINTENANCE);
        Person employee2 = new Employee(null, "gil2","laburante2","12345892",direction,new BigDecimal("40"), TypeEmployee.MAINTENANCE);
        Person employee3 = new Employee(null, "gil3","laburante3","12345893",direction,new BigDecimal("60000"), TypeEmployee.ADMINISTRATIVE);

        personDAO.save(employee1);
        personDAO.save(employee2);
        personDAO.save(employee3);



        Iterable<Person> employeesTypeMAINTENANCE = ((EmployeeDAO)personDAO).findEmployeesByTypeEmployee(TypeEmployee.ADMINISTRATIVE);
        employeesTypeMAINTENANCE.forEach(System.out::println);


     */
    }
}
