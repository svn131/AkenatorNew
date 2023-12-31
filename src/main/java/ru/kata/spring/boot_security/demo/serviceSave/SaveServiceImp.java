package ru.kata.spring.boot_security.demo.serviceSave;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;
import ru.kata.spring.boot_security.demo.repository.RepositoryZarodyshey;
import ru.kata.spring.boot_security.demo.util.ExcelWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SaveServiceImp implements SaveService {

    private RepositoryZarodyshey repositoryZarodyshey;

    private Repository repository;

    int colSovpadenyiDlyaZameny = 10;

    int colVoprosovNaNovoeDobavlenye = 15; // можно ставить хоть 10000 выше головы не прыгнет всеравно


    double percentage = 1.0; // 0.8 = 80% процент при котором выходит в продакшен

    @Autowired
    public SaveServiceImp(Repository userRepository, RepositoryZarodyshey repositoryZarodyshey) {
        this.repositoryZarodyshey = repositoryZarodyshey;
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
                    if (vopros.getOtvet() != voprosPamyty.getOtvet() && voprosPamyty.getOtvet() != 0) { //
                        listSomnenyi.add(vopros.getId());
                        nePoraliZapisat((ArrayList<Integer>) listSomnenyi, idZnamenitosty, voprosPamyty.getId(), voprosPamyty.getOtvet());
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
            ExcelWriter.writeCellValue("C:/AkinatorAI.xlsx", znamenitostId, voprosId, otvet);


            for (Znamenitost znamenitost : repository.getZnamenitostList()) {
                if (znamenitost.getId() == znamenitostId) {
                    for (Vopros vopros : znamenitost.getOtvetyList()) { //todo для замены в рантайме
                        if (voprosId == vopros.getId()) {
                            vopros.setOtvet(otvet);
                        }
                    }
                }
            }

            listSomnenyi.removeIf(num -> num == voprosId); // todo интерестный   метод


        }


    }


    public Znamenitost getnewZarodysh(Igrok igrok, String vveli) {
        List<Znamenitost> zarodishList = repositoryZarodyshey.getZarodishList();


        if (zarodishList != null) {
            for (Znamenitost zarodysh : zarodishList) {
                if (zarodysh.getName().equalsIgnoreCase(vveli)) {
                    napolnenyerVoprosovDobavkiEslyESTZarodysh(igrok, zarodysh);
                    return zarodysh;
                }
            }
        }
        Znamenitost znamenitost1 = new Znamenitost();
        znamenitost1.setOtvetyList(igrok.getListPamyty()); //todo проверить не перетираеться ли после игрока ремув
        znamenitost1.setName(vveli);
        znamenitost1.setId(repository.getZnamenitosty().size() + 1);

        napolnenyerVoprosovDobavkiEslyNEtZarodysha(igrok);
        return znamenitost1;


    }

    public void napolnenyerVoprosovDobavkiEslyESTZarodysh(Igrok igrok, Znamenitost zarodish) {
        igrok.setListVoprosovDlyaDobavlenyya(new ArrayList<Vopros>());
        List<Vopros> listVDDuIgroka = igrok.getListVoprosovDlyaDobavlenyya();
        List<Vopros> voprosListZaroddysh = zarodish.getOtvetyList();

//        voprosListZaroddysh.addAll(igrok.getListPamyty());


        List<Vopros> voprosListZaroddyshRess = Stream.concat(igrok.getListPamyty().stream(), voprosListZaroddysh.stream())
                .distinct()
                .collect(Collectors.toList());

        for (Vopros vopros : repository.getVoprosList()) {
            boolean isContained = false;
            for (Vopros vopros1 : voprosListZaroddyshRess) {
                if (vopros.getId() == vopros1.getId()) {
                    isContained = true;
                    break;
                }
            }

            if (!isContained) {
                listVDDuIgroka.add(vopros);
            }
        }
    }


    public void napolnenyerVoprosovDobavkiEslyNEtZarodysha(Igrok igrok) {

        igrok.setListVoprosovDlyaDobavlenyya(new ArrayList<Vopros>());

        for (Vopros vopros : repository.getVoprosList()) {
            boolean isContained = false;
            for (Vopros vopros1 : igrok.getListPamyty()) {
                if (vopros.getId() == vopros1.getId()) {
                    isContained = true;
                    break;
                }
            }

            if (!isContained) {
                igrok.getListVoprosovDlyaDobavlenyya().add(vopros);
            }
        }
    }


    public Vopros getRandowVopros(Igrok igrok) throws IOException {
        if (igrok.getListVoprosovDlyaDobavlenyya().size() > 0 && igrok.getSchetchikDobavlenyh() <= colVoprosovNaNovoeDobavlenye) {
            Vopros vopros = igrok.getListVoprosovDlyaDobavlenyya().get(0);
            igrok.incrimentSchetchikDobavlenyh();
            return vopros;
        } else {
            igrok.obnulenyeSchetchikDobavlenyh();
            Vopros vopros = new Vopros();
            vopros.setId(7007);
            vopros.setValue("7007");
            dobavlinyaZaradishaVrepo(igrok);
            proverkaAndWrite(igrok);
            removeIgrok(igrok);

            return vopros;
        }


    }


    public void setZadanyiVopros(Igrok igrok, int otvet) {
        Vopros vopros = igrok.getListVoprosovDlyaDobavlenyya().get(0);
        vopros.setOtvet(otvet);
        igrok.getListVoprosovDlyaDobavlenyya().remove(0);
        igrok.getZnamenitostDobalenya().getOtvetyList().add(vopros);

        igrok.incrimentSchetchikDobavlenyh();

    }


    public void dobavlinyaZaradishaVrepo(Igrok igrok) {

        List<Znamenitost> zarodishList = repositoryZarodyshey.getZarodishList();

        if (zarodishList != null) {
            for (Znamenitost znamenitost : zarodishList) {
                if (znamenitost.getId() == igrok.getZnamenitostDobalenya().getId()) {
                    znamenitost = igrok.getZnamenitostDobalenya();
                    return;
                }
            }

        }
        zarodishList.add(igrok.getZnamenitostDobalenya());

    }


    public void proverkaAndWrite(Igrok igrok) throws IOException {
        int uIgoka = igrok.getZnamenitostDobalenya().getOtvetyList().size();
        int vRepo = repository.getVoprosList().size();

        double threshold = vRepo * percentage;

        if (uIgoka >= threshold) {
            // код, который должен сработать при заполненности 100%

            Znamenitost znamenitost = igrok.getZnamenitostDobalenya();

            repository.getZnamenitostList().add(znamenitost);

            repositoryZarodyshey.getZarodishList().remove(znamenitost); // убираем из зародышей

            String name = znamenitost.getName();

            int pisatV = repository.getZnamenitostList().size();


            List<Vopros> listItvetov = igrok.getZnamenitostDobalenya().getOtvetyList();


            ExcelWriter.writeCellValue("C:/AkinatorAI.xlsx", pisatV, 0, name, listItvetov);


        }


    }


    public void removeIgrok(Igrok igrok) {
        repository.getListIgrokov().remove(igrok);
        System.out.println("RRRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEEEEEEMMMMMMMMMMMMOOOOOOOOOOOOVVVVVVVVVVVVVEEEEEEEEE");

    }


    public void umenshenyeVoprosEslivZarodysheUgheEst(Igrok igrok) {
        List<Vopros> listDlyDobVpros = igrok.getListVoprosovDlyaDobavlenyya();
        Znamenitost znamenitostDD = igrok.getZnamenitostDobalenya();

        List<Znamenitost> zarodyshList = repositoryZarodyshey.getZarodishList();

        for (Znamenitost zarodysh : zarodyshList) {
            if (zarodysh.getName().equals(znamenitostDD.getName())) {
                //стираем из лсита вопрососв для добавления те которые уже есть в зродыше
                List<Vopros> VoprosyKotoryeUgheByli = zarodysh.getOtvetyList();

                for (Vopros vopros : VoprosyKotoryeUgheByli) {
                    listDlyDobVpros.remove(vopros.getId() - 1);
                }


            }
        }
    }


    public Vopros getProshenuyPriorityVopros(Igrok igrok) { // обязательно только посл реформы

        List<Znamenitost> listVarikovSoshibkami = igrok.getListVozmohVariantovSohibkami();
        List<Vopros> listOstavshihsyaVoprosov = igrok.getListOstavshihsyaVoprosov();

        for (Vopros vopros : listOstavshihsyaVoprosov) {
            vopros.nulableSet(); // занулили
        }

        for (Vopros voprosIzOstvshihsya : listOstavshihsyaVoprosov)
            for (Znamenitost znamenitost : listVarikovSoshibkami) {
                for (Vopros otvetOdnoyZnamenytosty : znamenitost.getOtvetyList()) {
                    if (otvetOdnoyZnamenytosty.getId() == voprosIzOstvshihsya.getId()) {

                        if (otvetOdnoyZnamenytosty.getOtvet() == 1) {
                            voprosIzOstvshihsya.incremetCount1();
                        } else if (otvetOdnoyZnamenytosty.getOtvet() == -1) {
                            voprosIzOstvshihsya.incremetCountNimus1();                    // набиваем заного оценку вопросов

                        }


                    }
                }
            }

        Collections.sort(listOstavshihsyaVoprosov);

        int idy = igrok.getListOstavshihsyaVoprosov().get(igrok.getListOstavshihsyaVoprosov().size() - 1).getId();
        Vopros vopros = new Vopros();
        vopros.setId(idy);

        igrok.setListPamyty(vopros);    // обязательно добавить вопрос в лист памяти и убрать из листа оставшихся вопросов

        Vopros voprosNaVidachu = igrok.getListOstavshihsyaVoprosov().get(igrok.getListOstavshihsyaVoprosov().size() - 1);

        listOstavshihsyaVoprosov.remove(voprosNaVidachu);

        return voprosNaVidachu;

    }


    public void reformaProshennuh(Igrok igrok) {
//        igrok.setListVozmohVariantovSohibkami(new ArrayList<Znamenitost>());  // чистим данные со старого хода

        List<Znamenitost> reformiriemyiList = igrok.getListVozmohVariantovSohibkami();
        List<Znamenitost> tempList = new ArrayList<>();

        List<Vopros> listZadanyhVoprosov = igrok.getListPamyty();

        for (Znamenitost znamenitost : reformiriemyiList) {
            int oshhibki = 0;
            List<Vopros> listOtvetovEtoyZnamenytosty = znamenitost.getOtvetyList();
            for (Vopros otvetEtoyZnamenitosty : listOtvetovEtoyZnamenytosty) {
                for (Vopros otvetIgroka : listZadanyhVoprosov) {
                    if (otvetEtoyZnamenitosty.getId() == otvetIgroka.getId()) { // если
                        if (otvetEtoyZnamenitosty.getOtvet() != otvetIgroka.getOtvet()) {
                            oshhibki++;
                        }

                    }


                }

            }

            if (oshhibki <= 5) {
                tempList.add(znamenitost);
            }
        }

        reformiriemyiList = tempList;


    }


    public void loghimZnamenitostySoshibkamiVListVVSO(Igrok igrok) {

        igrok.setListVozmohVariantovSohibkami(new ArrayList<Znamenitost>());  // чистим данные со старого хода
        List<Znamenitost> listVariantovsOshibkami = igrok.getListVozmohVariantovSohibkami();

        List<Znamenitost> listvsehZnamenitostey = repository.getZnamenitostList();

        List<Znamenitost> listvsehZnamenitosteyKromePokazanuhhRanee = new ArrayList<>(listvsehZnamenitostey);




        listvsehZnamenitosteyKromePokazanuhhRanee.remove(igrok.listIstoryyPokazovZnamenitosteynaMorde.get(0)); // потом что тут показанна толко одна исключаем ее вообще


        for (Znamenitost znamenitost : listvsehZnamenitosteyKromePokazanuhhRanee) {
            int oshhibki = 0;
            List<Vopros> listOtvetovEtoyZnamenytosty = znamenitost.getOtvetyList();
            for (Vopros otvetEtoyZnamenitosty : listOtvetovEtoyZnamenytosty) {
                for (Vopros otvetIgroka : igrok.getListPamyty()) {
                    if (otvetEtoyZnamenitosty.getId() == otvetIgroka.getId()) { // если
                        if (otvetEtoyZnamenitosty.getOtvet() != otvetIgroka.getOtvet()) {
                            oshhibki++;
                        }

                    }


                }

            }

            if (oshhibki <= 5) {
                listVariantovsOshibkami.add(znamenitost);
            }
        }


    }
}


