package com.springboot.universidad.universidadbackend.model.entities;

import com.springboot.universidad.universidadbackend.model.entities.enumerators.Blackboard;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "classrooms")
public class Classroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number_classroom", nullable = false)
    private Integer numberClassroom;
    @Column(name = "measures_mtsxmts")
    private String measures;
    @Column(name = "number_of_desks")
    private Integer numberOfDesks;
    @Column(name = "type_blackboard")
    // para persistir un enumerado, debemos usar esta anotacion. De esta forma, persiste el nombre del enumarador
    @Enumerated(EnumType.STRING)
    private Blackboard blackboard;
    @Column(name = "high_date")
    private LocalDateTime high;
    @Column(name = "date_last_modified")
    private LocalDateTime lastModification;

    /** Se pueden poner mas de un tipo de cascade**/
    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "pavilion_id",
            foreignKey = @ForeignKey(name = "FK_PAVILION_ID")
    )
    private Pavilion pavilion;

    public Classroom() {
    }

    public Classroom(Integer id, Integer numberClassroom, String measures, Integer numberOfDesks, Blackboard blackboard) {
        this.id = id;
        this.numberClassroom = numberClassroom;
        this.measures = measures;
        this.numberOfDesks = numberOfDesks;
        this.blackboard = blackboard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberClassroom() {
        return numberClassroom;
    }

    public void setNumberClassroom(Integer numberClassroom) {
        this.numberClassroom = numberClassroom;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public Integer getNumberOfDesks() {
        return numberOfDesks;
    }

    public void setNumberOfDesks(Integer numberOfDesks) {
        this.numberOfDesks = numberOfDesks;
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public void setBlackboard(Blackboard blackboard) {
        this.blackboard = blackboard;
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

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
    }

    /** De esta manera nos evitamos hacer la logica de las fechas.
     * Si no que se encargara JPA de hacerlos por nosotros.
     * Este metodo se va a ejecutar antes de la persistencia del objeto **/
    @PrePersist
    private void beforePersisting(){
        this.high = LocalDateTime.now();
    }

    /** Este metodo se va a ejecutar antes de hacer el update del objeto **/
    @PreUpdate
    private void beforeUpdate(){
        this.lastModification = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", numberClassroom=" + numberClassroom +
                ", measures='" + measures + '\'' +
                ", numberOfDesks=" + numberOfDesks +
                ", blackboard=" + blackboard +
                ", high=" + high +
                ", lastModified=" + lastModification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id.equals(classroom.id) && numberClassroom.equals(classroom.numberClassroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberClassroom);
    }
}

