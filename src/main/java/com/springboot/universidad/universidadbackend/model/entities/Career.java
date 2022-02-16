package com.springboot.universidad.universidadbackend.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "careers")
public class Career implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(nullable = false, unique = true, length = 80)
    private String name;
    @Positive(message = "The value must be positive ")
    @Column(name = "amount_of_materials")
    private Integer amountOfMaterials;
    @Positive(message = "The value must be positive ")
    @Column(name = "amount_of_years")
    private Integer amountOfYears;
    @Column(name = "high_date")
    private LocalDateTime high;
    @Column(name = "date_last_modified")
    private LocalDateTime lastModification;

    @OneToMany(
            mappedBy = "career",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"career"})//cuando obtenga el studen, no tenga en cuenta su carrera
    private Set<Student> students;

    @ManyToMany(
            mappedBy = "careers",
            fetch = FetchType.LAZY
    )
    @JsonIgnoreProperties({"careers"})
    private Set<Teacher> teachers;


    public Career() {
    }

    public Career(Integer id, String name, Integer amountOfMaterials, Integer amountOfYears) {
        this.id = id;
        this.name = name;
        this.amountOfMaterials = amountOfMaterials;
        this.amountOfYears = amountOfYears;
        this.teachers = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfMaterials() {
        return amountOfMaterials;
    }

    public void setAmountOfMaterials(Integer amountOfMaterials) {
        this.amountOfMaterials = amountOfMaterials;
    }

    public Integer getAmountOfYears() {
        return amountOfYears;
    }

    public void setAmountOfYears(Integer amountOfYears) {
        this.amountOfYears = amountOfYears;
    }

    public LocalDateTime getHigh() {
        return high;
    }

    public void setHigh(LocalDateTime high) {
        this.high = high;
    }

    public LocalDateTime getLastModification() {
        return lastModification;
    }

    public void setLastModification(LocalDateTime lastModification) {
        this.lastModification = lastModification;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacherToCareer(Teacher teacher){
        this.teachers.add(teacher);
    }

    @PrePersist
    private void beforePersisting(){
        this.high = LocalDateTime.now();
    }

    @PreUpdate
    private void beforeUpdate(){
        this.lastModification = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfMaterials=" + amountOfMaterials +
                ", amountOfYears=" + amountOfYears +
                ", high=" + high +
                ", lastModified=" + lastModification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career career = (Career) o;
        return id.equals(career.id) && name.equals(career.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
