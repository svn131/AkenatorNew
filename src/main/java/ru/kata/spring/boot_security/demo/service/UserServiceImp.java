package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;
import ru.kata.spring.boot_security.demo.util.PsrserExel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImp implements UserService {

    private Repository repository;

    @Autowired
    public UserServiceImp(Repository userRepository) {
        this.repository = userRepository;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void removeIgrok(Igrok igrok){
        repository.getListIgrokov().remove(igrok);
        System.out.println("RRRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEEEEEEMMMMMMMMMMMMOOOOOOOOOOOOVVVVVVVVVVVVVEEEEEEEEE");

    }

//    public void removeIgrok(String kukiId){
//        Igrok igrokDeleted = new Igrok(kukiId);
//        for(Igrok igrok :repository.getListIgrokov()){
//            if(igrok.getIdKuki().equals(kukiId)){
//                igrokDeleted = igrok;
//            }
//        }
//
//        repository.getListIgrokov().remove(igrokDeleted);
//        System.out.println("RRRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEEEEEEMMMMMMMMMMMMOOOOOOOOOOOOVVVVVVVVVVVVVEEEEEEEEENEw");
//
//    }

    public void removeIgrok(String kukiId){
        repository.getListIgrokov().removeIf(igrok -> igrok.getIdKuki().equals(kukiId));
        System.out.println("REMOVEeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeD");
    }



    @Override
    public Igrok reforma(Igrok igrok,int otvet) {
        int idVoprosa = igrok.getListOstavshihsyaVoprosov().get(igrok.getListOstavshihsyaVoprosov().size() - 1).getId();
        igrok.getListOstavshihsyaVoprosov().remove(igrok.getListOstavshihsyaVoprosov().size()-1); // удаляет из игрокапойденый вопрос

        List<Znamenitost> znamenytostyNaIgru = igrok.getListVozmohnyhVariantov();
        List<Znamenitost> listResult = new ArrayList<>();

        if (otvet == 1) {
            for (Znamenitost znamenitost : znamenytostyNaIgru) {
                for (Vopros voprosOdnogoChela : znamenitost.getOtvetyList()) {

                    if (voprosOdnogoChela.getId() == idVoprosa){
                      if(voprosOdnogoChela.getOtvet() == 1 || voprosOdnogoChela.getOtvet() == 0){
                          listResult.add(znamenitost);
                      }
                    }

                }
            }
        }else if(otvet == -1){
            for (Znamenitost znamenitost : znamenytostyNaIgru) {
                for (Vopros voprosOdnogoChela : znamenitost.getOtvetyList()) {

                    if (voprosOdnogoChela.getId() == idVoprosa){
                        if(voprosOdnogoChela.getOtvet() == -1 || voprosOdnogoChela.getOtvet() == 0){
                            listResult.add(znamenitost);
                        }
                    }

                }
            }
        }else { // для 0 что бы удаляло пройденный вопрос
            return igrok;
        }

        igrok.setListVozmohnyhVariantov(listResult);
        return igrok;
    }

   public void setDovoprosaChekNaDooble(Igrok igrok){ /////////////////////////////////////////////////////////////////////////////////////////////////////todo обращать внимание
        igrok.sizeDoVoprosa = igrok.getListVozmohnyhVariantov().size();
   }

    @Override
    public boolean checkPosleVoprosa(Igrok igrok) { // если знаменитосей не уменьшилось значит приоретеный вопрос не смог нечего изменить все остальное одинаково или имеет нули .
        return igrok.sizeDoVoprosa == igrok.getListVozmohnyhVariantov().size();
    }





    public Igrok getIgrok(String kukiId){
      for(Igrok igrok :  repository.getListIgrokov()){
         if (igrok.getIdKuki().equals(kukiId)){//todo можно в будущем ==
             return igrok;
         }
      }
      return null;
//        return getNewIgrok(kukiId);/////////////////////////////////////////////////////////////////////////////
    }






    public Igrok getNewIgrok(String kukiId) {
        ArrayList<Znamenitost> znamenitostsList= new ArrayList<>();
        for (Znamenitost znamenitost : repository.getZnamenitostList()) {
            znamenitostsList.add(new Znamenitost(znamenitost));
        }
        ArrayList<Vopros> voprosList= new ArrayList<>();

        for (Vopros vopros : repository.getVoprosList()) {
            Vopros vop = new Vopros(vopros.getId(),vopros.getValue());

            voprosList.add(vopros);
        }

        Igrok igrok = new Igrok(kukiId, znamenitostsList, voprosList);
        repository.getListIgrokov().add(igrok);
        return igrok;
    }


    public void vivodVConsol() {

        for (Znamenitost odinChuvak : repository.getZnamenitostList()) {
            System.out.println(odinChuvak.getName());

            for (Vopros voprosik : odinChuvak.getOtvetyList()) {
                System.out.println(voprosik.getOtvet());
            }

        }
    }

    public void setNazadanyiRaneeVoprosVLP( Igrok igrok,int vibor){
        if(igrok.getListPamyty().size() != 0){
            igrok.getListPamyty().get(igrok.getListPamyty().size()-1).setOtvet(vibor); // логим
        }
    }


    public Vopros getPriorityVopros(Igrok igrok) { // todo упростить сушноси добавив ответы

        for (Vopros voprosDlyObnulenya : igrok.getListOstavshihsyaVoprosov()) {
            voprosDlyObnulenya.nulableSet();
        }


        for (Znamenitost znamenytost : igrok.getListVozmohnyhVariantov()) {
            for (Vopros vopros : znamenytost.getOtvetyList()) {
                for (Vopros resultVopros : igrok.getListOstavshihsyaVoprosov()) {
                    if (resultVopros.getId() == vopros.getId()) { // перебираем все вопросы - что бы знать статистику
                        if (vopros.getOtvet() == 1) {
                            resultVopros.incremetCount1();


                        } else if (vopros.getOtvet() == -1) {

                            System.out.println("----------------------------");
                            System.out.println(resultVopros.getId() + "  " + vopros.getId());
                            resultVopros.incremetCountNimus1();
                        }


                    }
                }
            }
        }
        Collections.sort(igrok.getListOstavshihsyaVoprosov()); // todo проверить правильно ли сортирует

//        System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
//
//        System.out.println(igrok.getListOstavshihsyaVoprosov().get(0).toString());
//        System.out.println(igrok.getListOstavshihsyaVoprosov().get(1).toString());
//        System.out.println(igrok.getListOstavshihsyaVoprosov().get(2).toString());
//        System.out.println(igrok.getListOstavshihsyaVoprosov().get(3).toString());

//todo pomenyt peremennuy 5 shtuk oboznachit korotko


            int idy = igrok.getListOstavshihsyaVoprosov().get(igrok.getListOstavshihsyaVoprosov().size() - 1).getId();
            Vopros vopros = new Vopros();
            vopros.setId(idy);

            igrok.setListPamyty(vopros);

        return igrok.getListOstavshihsyaVoprosov().get(igrok.getListOstavshihsyaVoprosov().size() - 1); // todo проверить самый путевый это 0 или последний ??

    }




//    public void obnulenyeCount(Igrok igrok){
//
//        for (Znamenitost znamenytost : igrok.getListVozmohnyhVariantov()) {
//            for (Vopros vopros : znamenytost.getOtvetyList()) {
//                for (Vopros resultVopros : igrok.getListOstavshihsyaVoprosov()) {
//    }


}













