package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.repository.Repository;

public interface UserService  {

    void vivodVConsol();

    public Repository getRepository();

    public Vopros getPriorityVopros(Igrok igrok,int vibor);

    public Igrok getNewIgrok (String kukiId);

    public Igrok getIgrok(String kukiId);

    public Igrok reforma(Igrok igrok , int otvet);

    public void removeIgrok(Igrok igrok);
}











//    Vopros getUserById(Long id);
//
//    List<Vopros> getListOfUsers();
//
//    void deleteUser(Long id);
//
//    void saveUser(Vopros user);

//    User findByEmail(String email);

