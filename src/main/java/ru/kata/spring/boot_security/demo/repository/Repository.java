package ru.kata.spring.boot_security.demo.repository;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;

import java.util.ArrayList;
import java.util.List;

@Component
public class Repository {


    List<Vopros> voprosList;

    List<Znamenitost> znamenitostList;

    List<Igrok> listIgrokov = new ArrayList<>();




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


    public List<Igrok> getListIgrokov() {
        return listIgrokov;
    }

    public void setListIgrokov(List<Igrok> listIgrokov) {
        this.listIgrokov = listIgrokov;
    }


    @Scheduled(fixedRate = 86400000)  // Запускать каждые 24 часа (в миллисекундах)
    public void obnovaMetod() {
        // Код обновления данных в сущности Repository
    }

}
