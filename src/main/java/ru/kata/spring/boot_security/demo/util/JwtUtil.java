//package ru.kata.spring.boot_security.demo.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import ru.kata.spring.boot_security.demo.model.Igrok;
//import ru.kata.spring.boot_security.demo.model.Vopros;
//import ru.kata.spring.boot_security.demo.model.Znamenitost;
//
//import javax.crypto.SecretKey;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//
//public class JwtUtil {
////    private static final String SECRET_KEY = "yourSecretKey";
//    private static final long EXPIRATION_TIME = 86400000; // 24 часа в миллисекундах
//
//    public static String generateToken(String userId) {
//
//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//        String sessionToken = Jwts.builder()
//                .setSubject(userId) // Установите идентификатор пользователя как subject токена
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Установите срок действия токена (expiration time)
//                .signWith(key) // Подпишите токен с использованием секретного ключа
//                .compact();
//
//        return sessionToken;
//    }
//}
//
//
//    @GetMapping()
//    @CrossOrigin(origins = "*")
//    public ResponseEntity<Vopros> vidachaFirst(HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("777777777777777777777777777777777777777777777777777777777777777777");
//
//        // Получаем значение сессионного токена из заголовка Authorization
//        String sessionToken = request.getHeader("Authorization");
//        if (sessionToken != null && sessionToken.startsWith("Bearer ")) {
//            sessionToken = sessionToken.substring(7);
//            System.out.println("Токен first ---------------------------------- " + sessionToken);
//        }
//
//        if (sessionToken == null) {
//            // Генерируем новый токен
//            sessionToken = JwtUtil.generateToken("userId");
//            response.addHeader("Authorization", "Bearer " + sessionToken);
//            System.out.println("Новый токен сгенерирован: " + sessionToken);
//        }
//
//        userService.removeIgrok(sessionToken);
//        Igrok igrok = userService.getNewIgrok(sessionToken);
//        Vopros vopros = userService.getPriorityVopros(igrok);
//
//        for (Znamenitost znamenitost : igrok.getListVozmohnyhVariantov()) {
//            System.out.println(znamenitost);
//        }
//
//        // Используйте значение sessionToken для идентификации пользователя
//        // Устанавливаем токен сессии в заголовок Authorization
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
//        response.addHeader("Authorization", "Bearer " + sessionToken);
//        System.out.println("Установлен токен: " + sessionToken);
//
//        return ResponseEntity.ok(vopros);
//    }
//
//
