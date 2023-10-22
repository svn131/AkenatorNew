package ru.kata.spring.boot_security.demo.repository;



import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;

import java.util.List;

@Component
public class Repository {


    List<Vopros> voprosList;

    List<Znamenitost> znamenitostList;




    public List<Vopros> getVoprosList() {
        return voprosList;
    }


    public void setVoprosList(List<Vopros> voprosList) {
        this.voprosList = voprosList;
    }

    public List<Znamenitost> getZnamenitosty() {
        return znamenitostList;
    }
//    public Znamenitost getZnamenitostList() {
//        Random random = new Random(2);
//        return znamenitostList.get(random);
//    }

    public void setZnamenitostList(List<Znamenitost> znamenitostList) {
        this.znamenitostList = znamenitostList;
    }

    public List<Znamenitost> getZnamenitostList() {
        return znamenitostList;
    }
}
