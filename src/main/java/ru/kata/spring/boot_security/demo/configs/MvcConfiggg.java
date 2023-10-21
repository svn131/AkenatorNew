package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiggg implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {

        System.out.println();
        registry.addViewController("/useraa").setViewName("akinat");
        registry.addViewController("/admin").setViewName("admin_page");
        registry.addViewController("/login").setViewName("login");
    }
}

