package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.repository.Repository;

public interface UserService  {

    void vivodVConsol();

    public Repository getRepository();

    public Vopros getFirsttVopros(Igrok igrok);

    public Igrok getNewIgrok (String kukiId);
}











//    Vopros getUserById(Long id);
//
//    List<Vopros> getListOfUsers();
//
//    void deleteUser(Long id);
//
//    void saveUser(Vopros user);

//    User findByEmail(String email);

