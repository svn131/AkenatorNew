package ru.kata.spring.boot_security.demo.model;



import javax.persistence.*;


@Entity
@Table(name = "znamenitost")
public class Znamenitost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Znamenitost() {
    }
}


