package com.springboot.universidad.universidadbackend.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person{

    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "career_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "students"})
    private Career career;

    public Student() {
    }

    public Student(Integer id, String name, String lastname, String dni, Direction direction) {
        super(id, name, lastname, dni, direction);
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tStudent{}";
    }
}
