package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.model.Vopros;


import java.util.List;


public interface UserService  {
    Vopros getUserById(Long id);

    List<Vopros> getListOfUsers();

    void deleteUser(Long id);

    void saveUser(Vopros user);

//    User findByEmail(String email);




}

