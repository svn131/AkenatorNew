package ru.kata.spring.boot_security.demo.repository;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Znamenitost;

import java.util.List;


@Component
public class RepositoryZarodyshey {

    List<Znamenitost> zarodishList;


    public RepositoryZarodyshey() {
    }


    public List<Znamenitost> getZarodishList() {
        return zarodishList;
    }

    public void setZarodishList(List<Znamenitost> zarodishList) {
        this.zarodishList = zarodishList;
    }


}
