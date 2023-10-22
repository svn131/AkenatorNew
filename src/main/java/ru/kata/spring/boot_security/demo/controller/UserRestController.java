package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
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
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> vidachaFirst() {
        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");
        Vopros vopros = new Vopros();
        vopros.setId(1);
        vopros.setValue("Gdeeeeeee  ?");
        return ResponseEntity.ok(vopros);
    }


    @PostMapping("yes")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> yes() {
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        Vopros vopros = new Vopros();
        vopros.setId(2);
        vopros.setValue("Yes");


        userService.vivodVConsol();




        return ResponseEntity.ok(vopros);
    }

    @PostMapping("no")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> no() {
        System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        Vopros vopros = new Vopros();
        vopros.setId(3);
        vopros.setValue("No");
        return ResponseEntity.ok(vopros);
    }

    @PostMapping("nany")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> nany() {
        System.out.println("7aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa77");
        Vopros vopros = new Vopros();
        vopros.setId(2);
        vopros.setValue("Nany");
        return ResponseEntity.ok(vopros);
    }

}
