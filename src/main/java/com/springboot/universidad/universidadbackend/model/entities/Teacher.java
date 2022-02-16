package com.springboot.universidad.universidadbackend.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "person_id")
public class Teacher extends Person {

    /** Lo recomendable es usar eñ tipo BigDecimal para las monedas**/
    private BigDecimal salary;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "teacher_career",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "career_id")
    )
    private Set<Career> careers;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String lastname, String dni, Direction direction, BigDecimal salary) {
        super(id, name, lastname, dni, direction);
        this.salary = salary;
        this.careers = new HashSet<>();
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Career> getCareers() {
        return careers;
    }

    public void setCareers(Set<Career> careers) {
        this.careers = careers;
    }

    public void addCareer(Career career){
        this.careers.add(career);
        career.addTeacherToCareer(this);
    }

    public void deletedCareer(Career career){
        this.careers.remove(career);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tTeacher{" +
                "salary=" + salary +
                '}';
    }
}
