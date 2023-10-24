//package ru.kata.spring.boot_security.demo.controller;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//
//@ControllerAdvice
//@ResponseBody
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = { NotLoggedInException.class })
//    protected ResponseEntity<Object> handleNotLoggedIn(
//            final NotLoggedInException ex, final WebRequest request
//    ) {
//        final String bodyOfResponse = ex.getMessage();
//
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(bodyOfResponse);
//
//
//    }
//}
