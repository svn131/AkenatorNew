package ru.kata.spring.boot_security.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "vopros")
public class Vopros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

}

