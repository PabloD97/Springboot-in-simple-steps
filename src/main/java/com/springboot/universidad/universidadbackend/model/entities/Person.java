package com.springboot.universidad.universidadbackend.model.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table( name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
/** SINGLE_TABLE: Quiere decir que vamos a tener una unica tabla con
 * todos los atributos de nuestras clases hijas.
 * Esto tiene mejor rendimiento, ya que todo va a estar
 * ubicado en unica tabla. Lo unico malo, es que lso atributos
 * de nuestrasn clases hijas tienen que permitir valores nulos.
 * Si tenemos algunas de estas restriciones, no la vamos a poder usar.
 **/

/** JOINED: Va a generar una tabla con los datos comunes en este caso,
 * van a ser los de personas y por cada clase hija, va a generar una tabla distinta.
 * Esto esta un poco mas normalizado y es mas flexible, ya que nos permite tener como tablas separadas
 * a cada uno de nuestras clases y atributos.
 * DESVENTAJA: Para cada consulta, tenemos que hacer un join con nuestra tabla padre
 **/

/** TABLE_PER_CLASS: Totalmente desaconsejada. Tendriamos redundancia de datos**/
/** Si no se hace lo de abajo, no se puede instanciar una entidad que herede de esta**/
/** Con @JsonTypeInfo aclaro que el json tiene que tener un field que indique el type.
 * Estos types pueden ser los nombrados en SubTypes**/
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Student.class, name = "student"),
        @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
        @JsonSubTypes.Type(value = Employee.class, name = "employee")
})
public abstract class Person implements Serializable {
/** Agregando la palabra abstract, la clase no se va poder instanciar. Pero si sus derivados **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 60)
    private String lastname;
    @Column(nullable = false, unique = true, length = 10)
    private String dni;
    @Column(name = "high_date")
    private LocalDateTime high;
    @Column(name = "date_last_modified")
    private LocalDateTime lastModification;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "postalCode", column = @Column(name = "postal_code")),
            @AttributeOverride(name = "department", column = @Column(name = "department")),
    })
    private Direction direction;

    public Person() {
    }

    public Person(Integer id, String name, String lastname, String dni, Direction direction) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.direction = direction;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni='" + dni + '\'' +
                ", high=" + high +
                ", lastModified=" + lastModification +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id) && dni.equals(person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }
}
