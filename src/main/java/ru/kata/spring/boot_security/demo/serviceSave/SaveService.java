package ru.kata.spring.boot_security.demo.serviceSave;

import ru.kata.spring.boot_security.demo.model.Igrok;

import java.io.IOException;

public interface SaveService {

    public boolean poisk(String vveli);

    public void pometkaVoprosov(String vveli, Igrok igrok) throws IOException;












}

