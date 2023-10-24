package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//            sessionId = new String();
        sessionId = UUID.randomUUID().toString();
        }
//
//         Создаем объект Vopros с id и value
//        Vopros vopros = new Vopros();
//        vopros.setId(2);
//        vopros.setValue("valyyy kyk" + sessionId);
        Igrok igrok = userService.getNewIgrok(sessionId);
        Vopros vopros = userService.getPriorityVopros(igrok);
//        igrok.setZaddanyiVopros(vopros.getId());

// Используйте значение sessionId для идентификации пользователя
// Устанавливаем куку сессии в ответе сервера
//        response.addHeader("Set-Cookie", "session_id=" + sessionId);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionId);

        System.out.println("SEEEEEEEEEEEEEET " + sessionId);


        return ResponseEntity.ok(vopros);
    }


    @PostMapping("yes")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> yes(HttpServletRequest request, HttpServletResponse response) {
        //        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        Vopros vopros = new Vopros();
//        vopros.setId(2);
//        vopros.setValue("Yes");
//
//
//        userService.vivodVConsol();
        String sessionIda = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_id")) {
                    sessionIda = cookie.getValue();
                    System.out.println("кука first ---------------------------------- " + sessionIda);
                    break;
                }
            }

        }

        System.out.println("2GEEEEEEEEEEEEEEEET " + sessionIda);

        Igrok igrok = userService.getIgrok(sessionIda); // todo error ?
        System.out.println(igrok.toString());


//        igrok.getListOstavshihsyaVoprosov().remove(igrok.getListOstavshihsyaVoprosov().size()-1);



        userService.reforma(igrok, 1);


       int ostalos = igrok.getListVozmohnyhVariantov().size();

        Vopros vopros = userService.getPriorityVopros(igrok);


            // Выполнение редиректа на другую страницу
//            throw new NotLoggedInException("please log in", "/ugadal");

//
        if (ostalos == 1) {

            System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");

            vopros = new Vopros();
            vopros.setId(5000);
            vopros.setValue("Yes");

        }

        if (ostalos == 0 || igrok.getListOstavshihsyaVoprosov().size() == 0) {
            vopros = new Vopros();
            vopros.setId(5001);
            vopros.setValue("Yes");

        }







//        int ostalos = 1;

//        if (ostalos == 1) {
//
//            System.out.println("FIIIIIIIIIIIIIIIIIIIIIIIIII");
//
//
//            vopros = new Vopros();
//            vopros.setId(5000);
//            vopros.setValue("Yes");
//
//        }

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionIda);
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
                    System.out.println("кука---------------------------------- " + sessionId);
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


//    @GetMapping("/neznayuChto")
//    public String neznayuChto (){
//        System.out.println("piiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        return "redirect:/neznayuChto";
//    }


//    @GetMapping()
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<Vopros> vidachaFirst() {
//        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");
//        Vopros vopros = new Vopros();
//        vopros.setId(1);
//        vopros.setValue("Gdeeeeeee  ?");
//        return ResponseEntity.ok(vopros);
//    }


}
