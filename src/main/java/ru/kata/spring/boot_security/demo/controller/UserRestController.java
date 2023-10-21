package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@RestController
@RequestMapping("/userProfile")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Vopros> getUser(Principal principal) {
        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");
        Vopros vopros = new Vopros();
        vopros.setId(1L);
        vopros.setValue("Gdeeeeeee");
        return ResponseEntity.ok(vopros);
    }


}
