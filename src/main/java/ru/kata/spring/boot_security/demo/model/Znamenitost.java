package ru.kata.spring.boot_security.demo.model;


import javax.persistence.*;
import java.util.ArrayList;
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

    private List<Integer> listSomnenyi = new ArrayList<>();


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

    public Znamenitost(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public List<Vopros> getOtvetyList() {
        return otvetyList;
    }

    public void setOtvetyList(List<Vopros> otvetyList) {
        this.otvetyList = otvetyList;
    }

    public Znamenitost(Znamenitost znamenitost) {
        this.id = znamenitost.id;
        this.name = new String(znamenitost.getName());

        // Клонирование списка otvetyList
        if (znamenitost.otvetyList != null) {
            this.otvetyList = new ArrayList<>();
            for (Vopros vopros : znamenitost.otvetyList) {
                this.otvetyList.add(new Vopros(vopros));
            }
        }

//        // Клонирование массива badVopros
//        if (znamenitost.badVopros != null) {
//            this.badVopros = znamenitost.badVopros.clone();
//        }
    }


    public List<Integer> getListSomnenyi() {
        return listSomnenyi;
    }

    public void addListSomnenyi(Integer i) {
        listSomnenyi.add(i);
    }


    @Override
    public String toString() {
        return "Znamenitost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", otvetyList=" + otvetyList +
                ", listSomnenyi=" + listSomnenyi +
                '}';
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Znamenitost other = (Znamenitost) obj;
        return id == other.id;
    }

}




