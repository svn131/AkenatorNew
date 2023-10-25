package ru.kata.spring.boot_security.demo.serviceSave;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;
import ru.kata.spring.boot_security.demo.util.ExcelWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaveServiceImp implements SaveService {

    private Repository repository;

    int colSovpadenyiDlyaZameny = 2;

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

    public void pometkaVoprosov(String vveli, Igrok igrok) throws IOException {

        List<Vopros> redactList = new ArrayList<>();
        List<Integer> listSomnenyi = new ArrayList<>();
        int idZnamenitosty = 0;
        for (Znamenitost znamenitost : repository.getZnamenitostList()) {
            if (znamenitost.getName().equalsIgnoreCase(vveli)) {
                redactList = znamenitost.getOtvetyList();// todo помечаем на конкретной знаменитости вопросы
                listSomnenyi = znamenitost.getListSomnenyi();
                idZnamenitosty = znamenitost.getId();
            }
        }

        for (Vopros voprosPamyty : igrok.getListPamyty()) {
            for (Vopros vopros : redactList) {
                if (voprosPamyty.getId() == vopros.getId()) {
                    if (vopros.getOtvet() != voprosPamyty.getOtvet() && voprosPamyty.getOtvet() != 0) {
                        listSomnenyi.add(vopros.getId());
                        nePoraliZapisat((ArrayList<Integer>) listSomnenyi,idZnamenitosty,voprosPamyty.getId(),voprosPamyty.getOtvet());
                    } //todo ненадо оправдания в случае нормальных резултов и так поменяеться е стоит утежелять логику
                }
            }
        }

// todo proverkaLista na 3 i bolee sovpadenyi

    }

    public void nePoraliZapisat(ArrayList<Integer> listSomnenyi, int znamenitostId, int voprosId, int otvet) throws IOException {

        long count = listSomnenyi.stream()
                .filter(num -> num == voprosId)
                .count();

        if (count >= colSovpadenyiDlyaZameny) {
            System.out.println("Zapisssssssssssssssssssssssssssssssssssssssssssssssssss");
            ExcelWriter.writeCellValue("C:/AkinatorAI.xlsx", znamenitostId, voprosId, String.valueOf(otvet));

            listSomnenyi.removeIf(num -> num == voprosId); // todo интерестный   метод


        }



    }

}