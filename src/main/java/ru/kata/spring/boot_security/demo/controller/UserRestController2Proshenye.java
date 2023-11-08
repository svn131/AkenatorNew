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
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.serviceSave.SaveService;
//import ru.kata.spring.boot_security.demo.util.JwtUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.UUID;


@RestController
@RequestMapping("/userProfile2")
public class UserRestController2Proshenye {


    private  UserService userService;

    private SaveService saveService;

    @Autowired
    public UserRestController2Proshenye(UserService userService,SaveService saveService) {
        this.userService = userService;
        this.saveService = saveService;
    }

    @GetMapping()
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> vidachaFirst(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");

        // Получаем значение сессионной куки
        String sessionId = null;
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session_id")) {
                sessionId = cookie.getValue();
                System.out.println("кука first ---------------------------------- " + sessionId);
                break;
            }
        }


        Vopros vopros = new Vopros();

        Igrok igrok = userService.getIgrok(sessionId);

        igrok.poshliProshenyeVoprosy = true;

        int ostalosProZnamenitostey = igrok.getListVozmohVariantovSohibkami().size();

        if(ostalosProZnamenitostey == 0){
            vopros.setId(5000);// na neznayku
            vopros.setValue("neznayu");


    } else if (ostalosProZnamenitostey == 1) {
            vopros.setId(5011);// na Conec
            vopros.setValue("conec");
        }else {


             vopros = saveService.getProshenuyPriorityVopros(igrok); // todo pochistit vse ostavsheesya varianty
             vopros.setId(vopros.getId());
             vopros.setValue(vopros.getValue());

         }


        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionId);

        System.out.println("SEEEEEEEEEEEEEET " + sessionId);


        return ResponseEntity.ok(vopros);
    }


    @PostMapping("yes")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> yes(HttpServletRequest request, HttpServletResponse response) {


        // Получаем значение сессионной куки
        String sessionId = null;
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session_id")) {
                sessionId = cookie.getValue();
                System.out.println("кука first ---------------------------------- " + sessionId);
                break;
            }
        }


        Vopros vopros = new Vopros();

        Igrok igrok = userService.getIgrok(sessionId);


        saveService.reformaProshennuh(igrok, 1);


        int ostalosProZnamenitostey = igrok.getListVozmohVariantovSohibkami().size();

        if(ostalosProZnamenitostey == 0){
            vopros.setId(5000);// na neznayku
            vopros.setValue("neznayu");


        } else if (ostalosProZnamenitostey == 1) {
            vopros.setId(5011);// na Conec
            vopros.setValue("conec");
        }else {



            vopros.setId(5012);
            vopros.setValue("vdr"); // na COnecVerDoRest

        }

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionId);
        return ResponseEntity.ok(vopros);
    }


    @PostMapping("no")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> no(HttpServletRequest request, HttpServletResponse response) {


        // Получаем значение сессионной куки
        String sessionId = null;
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session_id")) {
                sessionId = cookie.getValue();
                System.out.println("кука first ---------------------------------- " + sessionId);
                break;
            }
        }


        Vopros vopros = new Vopros();

        Igrok igrok = userService.getIgrok(sessionId);


        saveService.reformaProshennuh(igrok, 1);


        int ostalosProZnamenitostey = igrok.getListVozmohVariantovSohibkami().size();

        if(ostalosProZnamenitostey == 0){
            vopros.setId(5000);// na neznayku
            vopros.setValue("neznayu");


        } else if (ostalosProZnamenitostey == 1) {
            vopros.setId(5011);// na Conec
            vopros.setValue("conec");
        }else {



            vopros.setId(5012);
            vopros.setValue("vdr"); // na COnecVerDoRest

        }

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionId);
        return ResponseEntity.ok(vopros);
    }

    @PostMapping("nany")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> nany(HttpServletRequest request, HttpServletResponse response) { //todo добавляем в лист памяти ??

        // Получаем значение сессионной куки
        String sessionId = null;
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("session_id")) {
                sessionId = cookie.getValue();
                System.out.println("кука first ---------------------------------- " + sessionId);
                break;
            }
        }


        Vopros vopros = new Vopros();

        Igrok igrok = userService.getIgrok(sessionId);


        saveService.reformaProshennuh(igrok, 1);


        int ostalosProZnamenitostey = igrok.getListVozmohVariantovSohibkami().size();

        if(ostalosProZnamenitostey == 0){
            vopros.setId(5000);// na neznayku
            vopros.setValue("neznayu");


        } else if (ostalosProZnamenitostey == 1) {
            vopros.setId(5011);// na Conec
            vopros.setValue("conec");
        }else {



            vopros.setId(5012);
            vopros.setValue("vdr"); // na COnecVerDoRest

        }

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionId);
        return ResponseEntity.ok(vopros);
    }


}

// todo прописать везде что в случае если 0 то перейти на незнаю