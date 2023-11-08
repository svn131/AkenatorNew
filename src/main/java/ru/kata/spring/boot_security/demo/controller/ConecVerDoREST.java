package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.serviceSave.SaveService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;


@RestController
@RequestMapping("/conecVrDo")
public class ConecVerDoREST {


    private final UserService userService;
    private final SaveService saveService;

    @Autowired
    public ConecVerDoREST(UserService userService, SaveService saveService) {
        this.userService = userService;
        this.saveService = saveService;
    }

    @GetMapping()
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> vidachaFirst(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("11111111111111111111111111111111111111111");


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


        Igrok igrok = userService.getIgrok(sessionIda); // todo error ?


        String otvet = "";
        Vopros vopros = new Vopros();

        if (!igrok.poshliProshenyeVoprosy) {

            saveService.loghimZnamenitostySoshibkamiVListVVSO(igrok);

            List<Znamenitost> ostavhieshesaVariantIinogaty = igrok.getListVozmohnyhVariantov();

            otvet = ostavhieshesaVariantIinogaty.get(0).getName(); // todo esli netu =0 прописать логику----------------------
            igrok.listIstoryyPokazovZnamenitosteynaMorde.add(ostavhieshesaVariantIinogaty.get(0)); //запоминаем знаменитости же спрашивали которые

            if (ostavhieshesaVariantIinogaty.size() > 1) { // не будет только если функция дубля попустит парочку иза того что не убавляеться
                otvet = null;
                StringJoiner joiner = new StringJoiner(" или ");
                for (Znamenitost znamenitost : ostavhieshesaVariantIinogaty) {
                    joiner.add(znamenitost.getName());
                    igrok.listIstoryyPokazovZnamenitosteynaMorde.add(znamenitost); //todo возможно убрать блок дублей ??  //запоминаем знаменитости же спрашивали которые
                }
                otvet = joiner.toString();
            }else if(ostavhieshesaVariantIinogaty.size() == 0){

                otvet = igrok.getListVozmohVariantovSohibkami().get(0).getName();
                igrok.listIstoryyPokazovZnamenitosteynaMorde.add(igrok.getListVozmohVariantovSohibkami().get(0)); //запоминаем знаменитости же спрашивали которые
                vopros.setId(5002);
                vopros.setValue(otvet);
            }


            vopros.setId(5002);
            vopros.setValue(otvet);

        } else {

            otvet = igrok.getListVozmohVariantovSohibkami().get(0).getName();
            igrok.listIstoryyPokazovZnamenitosteynaMorde.add(igrok.getListVozmohVariantovSohibkami().get(0));  //запоминаем знаменитости же спрашивали которые

            vopros.setId(5002);
            vopros.setValue(otvet);
        }




        ////////
        //        //логика текстового вывода
        //
        //
        ////////
        // Читаем содержимое файла, если оно есть
        if (otvet != null) {
            String filename = otvet + ".txt";
//            String filename =  "1.txt";
            String filePath = "C:\\333\\" + filename;

            File file = new File(filePath);


            // Проверяем, существует ли файл
            if (file.exists()) {
                StringBuilder content = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
//                    content.append(line).append("\
                    content.append(line).append("<br>"); // или content.append(line).append("\n");

                }
                reader.close();

                // Добавляем содержимое файла к ответу
//                vopros.setValue(vopros.getValue() + "\n" + content.toString());
                vopros.setValue(vopros.getValue() + "<br>" + content.toString());

            }
        }
        //


        return ResponseEntity.ok(vopros);
    }

    @PostMapping("yes")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> yes(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("REEEE");
        System.out.println("REEEEEEEEEEE");


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

        userService.removeIgrok(igrok);


        Vopros vopros = new Vopros();
        vopros.setId(5000); //новая игра
        vopros.setValue("Yes");


        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionIda);
        return ResponseEntity.ok(vopros);
    }


    @PostMapping("no")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vopros> no(@RequestBody Map<String, String> requestBody, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userInput = requestBody.get("input"); // Получение переданного текста


        System.out.println("MFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFV");
        System.out.println(userInput);

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

        System.out.println("2GEEEEEEEEEEEEEEEETneugadal " + sessionIda);

        Igrok igrok = userService.getIgrok(sessionIda); // todo error ?



        Vopros vopros = new Vopros();

        if (igrok.getListOstavshihsyaVoprosov().size() == 0) {
            vopros.setId(5010); // отправляем на незнаю
            vopros.setValue("NoneInfo");

        } else {


            vopros.setId(5008); // отправляем задать вопос UserRestController2
            vopros.setValue("newVopros");


        }


        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // разрешает не чистить кэш
        response.addHeader("Set-Cookie", "session_id=" + sessionIda);
        return ResponseEntity.ok(vopros);
    }
}