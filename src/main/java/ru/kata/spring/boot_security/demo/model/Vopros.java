package ru.kata.spring.boot_security.demo.model;


import javax.persistence.*;

//@Entity
//@Table(name = "vopros")
public class Vopros {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String value;


    private int otvet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vopros() {
    }

    public Vopros(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getOtvet() {
        return otvet;
    }

    public void setOtvet(int otvet) {
        this.otvet = otvet;
    }

    public Vopros(int otvet) {
        this.otvet = otvet;
    }
}

