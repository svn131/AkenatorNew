package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiggg implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {

        System.out.println();
        registry.addViewController("/myProject").setViewName("akinat");
        registry.addViewController("/sestest").setViewName("sesion_test");
//        registry.addViewController("userProfile/ugadal").setViewName("ugadal"); // Добавьте эту строку
//        registry.addViewController("userProfile/neznayuChto").setViewName("neznayuChto"); // Добавьте эту строку
//        registry.addViewController("/neznayuChto").setViewName("neznayuChto"); // Добавьте эту строку

//        registry.addViewController("/login").setViewName("login");
    }
}

