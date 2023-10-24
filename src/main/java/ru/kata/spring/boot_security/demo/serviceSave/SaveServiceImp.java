package ru.kata.spring.boot_security.demo.serviceSave;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaveServiceImp implements SaveService {

    private Repository repository;

    @Autowired
    public SaveServiceImp(Repository userRepository) {
        this.repository = userRepository;
    }


    @Override
    public boolean poisk(String vveli) {
        for (Znamenitost znamenitost : repository.getZnamenitostList()) {
            if (znamenitost.getName().equalsIgnoreCase(vveli)) {
                return true;
            }
        }
        return false;
    }

    public void pometkaVoprosov(String vveli, Igrok igrok) {

        List<Vopros> redactList = new ArrayList<>();
        List<Integer> listSomnenyi = new ArrayList<>();
        for (Znamenitost znamenitost : repository.getZnamenitostList()) {
            if (znamenitost.getName().equalsIgnoreCase(vveli)) {
                redactList = znamenitost.getOtvetyList();// todo помечаем на конкретной знаменитости вопросы
                listSomnenyi = znamenitost.getListSomnenyi();
            }
        }

        for (Vopros voprosPamyty : igrok.getListPamyty()) {
            for (Vopros vopros : redactList) {
                if (voprosPamyty.getId() == vopros.getId()) {
                    if (vopros.getOtvet() != voprosPamyty.getOtvet()) {
                        listSomnenyi.add(vopros.getId());
                    }
                }
            }
        }
// todo proverkaLista na 3 i bolee sovpadenyi

    }




}

