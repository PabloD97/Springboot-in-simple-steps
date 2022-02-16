package com.springboot.universidad.universidadbackend.model.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pavilions")
public class Pavilion  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "square_meter")
    private Double mts2;
    @Column(name = "name_pavilion", unique = true, nullable = false)
    private String name;
    @Embedded // ahora sabe que este atributo debe agregarlo como parte de la table y no como una tabal aparte
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code")),
            @AttributeOverride(name = "department", column = @Column(name = "department")),
    })
    private Direction direction;
    @Column(name = "high_date")
    private LocalDateTime high;
    @Column(name = "date_last_modified")
    private LocalDateTime lastModification;

    /** Siempre que la terminacion de nuestra relacion sea Many,
     * es recomendable que el fetch sea LAZY para no tener tanda demanda
     * en la DB**/
    @OneToMany(
            mappedBy = "pavilion",
            fetch = FetchType.LAZY
    )
    private Set<Classroom> classrooms;

    public Pavilion() {
    }

    public Pavilion(Integer id, Double mts2, String name, Direction direction) {
        this.id = id;
        this.mts2 = mts2;
        this.name = name;
        this.direction = direction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
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
        return "Pavilion{" +
                "id=" + id +
                ", mts2=" + mts2 +
                ", name='" + name + '\'' +
                ", direction=" + direction +
                ", high=" + high +
                ", lastModification=" + lastModification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pavilion pavilion = (Pavilion) o;
        return id.equals(pavilion.id) && name.equals(pavilion.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
