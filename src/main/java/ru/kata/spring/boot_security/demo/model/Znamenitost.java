package ru.kata.spring.boot_security.demo.model;



import javax.persistence.*;
import java.util.List;


//@Entity
//@Table(name = "znamenitost")
public class Znamenitost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @OneToMany(mappedBy = "astonishments", cascade = CascadeType.ALL)
    private List<Vopros> otvetyList;

    private int[] badVopros;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
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

    public Znamenitost(String name) {
        this.name = name;
    }

    public List<Vopros> getOtvetyList() {
        return otvetyList;
    }

    public void setOtvetyList(List<Vopros> otvetyList) {
        this.otvetyList = otvetyList;
    }




}


