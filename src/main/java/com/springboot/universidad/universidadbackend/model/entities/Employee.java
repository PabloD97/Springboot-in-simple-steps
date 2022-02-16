package com.springboot.universidad.universidadbackend.model.entities;

import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table( name = "employees")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person{

    private BigDecimal salary;

    @Column(name = "type_employee")
    @Enumerated(EnumType.STRING)
    private TypeEmployee typeEmployee;

    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "pavilion_id",
            foreignKey = @ForeignKey(name = "FK_PAVILION_ID")
    )
    private Pavilion pavilion;

    public Employee() {
    }

    public Employee(Integer id, String name, String lastname, String dni, Direction direction, BigDecimal salary, TypeEmployee typeEmployee) {
        super(id, name, lastname, dni, direction);
        this.salary = salary;
        this.typeEmployee = typeEmployee;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
    }

    @Override
    public String toString() {
        // \t para que haya un espacio entre la clase hija y empleado
        return super.toString() +
                "\tEmployee{" +
                "salary=" + salary +
                ", typeEmployee=" + typeEmployee +
                '}';
    }


}
