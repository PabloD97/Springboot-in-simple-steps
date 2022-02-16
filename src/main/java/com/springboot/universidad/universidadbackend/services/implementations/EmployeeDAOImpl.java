package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Employee;
import com.springboot.universidad.universidadbackend.model.entities.Pavilion;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;
import com.springboot.universidad.universidadbackend.repositories.EmployeeRepository;
import com.springboot.universidad.universidadbackend.repositories.PersonRepository;
import com.springboot.universidad.universidadbackend.services.contracts.EmployeeDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PavilionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDAOImpl extends PersonDAOImpl implements EmployeeDAO {

    @Autowired
    private PavilionDAO pavilionService;

    @Autowired
    public EmployeeDAOImpl(@Qualifier("repositoryEmployee") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> findEmployeesByTypeEmployee(TypeEmployee typeEmployee) {
        return ((EmployeeRepository)repository).findEmployeesByTypeEmployee(typeEmployee);
    }

    @Transactional
    @Override
    public Person assignPavilion(Integer idEmployee, Integer idPavilion){
        Employee employee = (Employee) (repository.findById(idEmployee).get());
        Pavilion pavilion = pavilionService.findById(idPavilion).get();

        employee.setPavilion(pavilion);
        return repository.save(employee);
    }
}
