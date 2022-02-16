package com.springboot.universidad.universidadbackend.model.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;


//esto no va ser una entidad, si no una clase/objeto embebido dentro de otra.
// Al momento de cargar va a buscar directamente las que tienen anotation @Entity y
// no va tener en cuenta las clases que esten decoradas con @Embeddable
@Embeddable
public class Direction implements Serializable {

    private String street;
    private String number;
    private String postalCode;
    private String department;
    private String floor;
    private String location;

    public Direction() {
    }

    public Direction(String street, String number, String postalCode, String department, String floor, String location) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.department = department;
        this.floor = floor;
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", department='" + department + '\'' +
                ", floor='" + floor + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
