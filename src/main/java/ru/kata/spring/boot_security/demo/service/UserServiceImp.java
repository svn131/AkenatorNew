package ru.kata.spring.boot_security.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.repository.Repository;
import ru.kata.spring.boot_security.demo.util.PsrserExel;

import java.util.Collections;
import java.util.List;


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


    public Vopros getFirsttVopros(Igrok igrok) { // todo упростить сушноси добавив ответы

        List<Vopros> resulList = repository.getVoprosList();

        for (Znamenitost znamenytost : igrok.getListVozmohnyhVariantov()) {
            for (Vopros vopros : znamenytost.getOtvetyList()) {

                for (Vopros resultVopros : resulList) {
                    if (resultVopros.getId() == vopros.getId()) { // перебираем все вопросы - что бы знать статистику

                        if (vopros.getOtvet() == 1) {
                            resultVopros.incremetCount1();
                        } else if (vopros.getOtvet() == -1) {
                            resultVopros.incremetCountNimus1();
                        }


                    }
                }
            }
        }
                Collections.sort(resulList); // todo проверить правильно ли сортирует
                System.out.println(resulList.toString());


                return resulList.get(0); // todo проверить самый путевый это 0 или последний ??

            }

public Igrok getNewIgrok (String kukiId){
      return new Igrok(kukiId,repository.getZnamenitostList(),repository.getVoprosList());
    }

//    public Vopros getPrioritetVopros(Igrok igrok){
//        igrok.


//        }


            public void vivodVConsol () {

                for (Znamenitost odinChuvak : repository.getZnamenitostList()) {
                    System.out.println(odinChuvak.getName());

                    for (Vopros voprosik : odinChuvak.getOtvetyList()) {
                        System.out.println(voprosik.getOtvet());
                    }

                }
            }

        }













//    @Override
//    public Vopros getUserById(Long id) {
//        Vopros user = null;
//        Optional<Vopros> optionalUser = repository.findById(id);
//        if (optionalUser.isPresent()) {
//            user = optionalUser.get();
//        }
//        return user;
//    }
//
//    @Override
//    public List<Vopros> getListOfUsers() {
//        return userRepository.findAll();
//    }
//
//
//    @Override
//    @Transactional
//    public void saveUser(Vopros user) {
//        userRepository.save(user);
//    }
//
//
//    @Override
//    @Transactional
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }



//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }