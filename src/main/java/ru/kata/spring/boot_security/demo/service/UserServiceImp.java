package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.repository.VorosRepository;


import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {

    private final VorosRepository userRepository;

    @Autowired
    public UserServiceImp(VorosRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Vopros getUserById(Long id) {
        Vopros user = null;
        Optional<Vopros> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        return user;
    }

    @Override
    public List<Vopros> getListOfUsers() {
        return userRepository.findAll();
    }


    @Override
    @Transactional
    public void saveUser(Vopros user) {
        userRepository.save(user);
    }


    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



//    @Override
//    public User findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
}


