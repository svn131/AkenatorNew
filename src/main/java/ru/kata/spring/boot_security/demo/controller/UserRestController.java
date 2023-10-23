package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Random;
import java.util.UUID;


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
    public ResponseEntity<Vopros> vidachaFirst(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");

        // Получаем значение сессионной куки
        String sessionId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_id")) {
                    sessionId = cookie.getValue();
                    System.out.println("кука first ---------------------------------- "+ sessionId);
                    break;
                }
            }
        }else {
            // Генерируем уникальный идентификатор для сессии
           sessionId = UUID.randomUUID().toString();
        }

        // Создаем объект Vopros с id и value
        Vopros vopros = new Vopros();
        vopros.setId(2);
        vopros.setValue("valyyy kyk" + sessionId);

// Используйте значение sessionId для идентификации пользователя
// Устанавливаем куку сессии в ответе сервера
        response.addHeader("Set-Cookie", "session_id=" + sessionId);

        return ResponseEntity.ok(vopros);
    }



//    @GetMapping()
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<Vopros> vidachaFirst() {
//        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");
//        Vopros vopros = new Vopros();
//        vopros.setId(1);
//        vopros.setValue("Gdeeeeeee  ?");
//        return ResponseEntity.ok(vopros);
//    }


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
//    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> no() {
        System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        Vopros vopros = new Vopros();
        vopros.setId(3);
        vopros.setValue("No");
        return ResponseEntity.ok(vopros);
    }

    @PostMapping("nany")
//    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> nany() {
        System.out.println("7aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa77");
        Vopros vopros = new Vopros();
        vopros.setId(1);
        vopros.setValue("Nany");
        return ResponseEntity.ok(vopros);
    }

    @PostMapping("/sesionnn")
    @CrossOrigin(origins = "*")
    public ResponseEntity sesionnn(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        // Генерируем случайное число
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(43);

        // Получаем значение сессионной куки
        String sessionId = String.valueOf(randomNumber);
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_id")) {
                    sessionId = cookie.getValue();
                    System.out.println("кука---------------------------------- "+ sessionId);
                    break;
                }
            }
        }

        // Создаем объект Vopros с id и value
        Vopros vopros = new Vopros();
        vopros.setId(randomNumber);
        vopros.setValue(String.valueOf(randomNumber));

        // Используйте значение sessionId для идентификации пользователя
// Устанавливаем куку сессии в ответе сервера
        if (sessionId != null) {
            response.addHeader("Set-Cookie", "session_id=" + sessionId);
        }

        return ResponseEntity.ok(vopros);
    }



}
