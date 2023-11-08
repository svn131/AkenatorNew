package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiggg implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {


        registry.addViewController("/myProject").setViewName("akinat");
        registry.addViewController("/sestest").setViewName("sesion_test");
        registry.addViewController("/ugadal").setViewName("ugadal"); // Добавьте эту строку
        registry.addViewController("/newSuhnost").setViewName("/newSuhnost"); // Добавьте эту строку
        registry.addViewController("/new_game").setViewName("/new_game"); // Добавьте эту строку
        registry.addViewController("/neznayuChto").setViewName("/neznayuChto"); // Добавьте эту строку
        registry.addViewController("/ugadalverdo").setViewName("/ugadalverdo"); // Добавьте эту строку
        registry.addViewController("/userProfile2").setViewName("/akinat2"); // Добавьте эту строку

//        registry.addViewController("userProfile/neznayuChto").setViewName("neznayuChto"); // Добавьте эту строку
//        registry.addViewController("/neznayuChto").setViewName("neznayuChto"); // Добавьте эту строку

//        registry.addViewController("/login").setViewName("login");
    }
}

