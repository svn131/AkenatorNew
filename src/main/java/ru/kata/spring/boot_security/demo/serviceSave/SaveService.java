package ru.kata.spring.boot_security.demo.serviceSave;

import ru.kata.spring.boot_security.demo.model.Igrok;
import ru.kata.spring.boot_security.demo.model.Vopros;
import ru.kata.spring.boot_security.demo.model.Znamenitost;

import java.io.IOException;

public interface SaveService {

    public boolean poisk(String vveli);

    public void pometkaVoprosov(String vveli, Igrok igrok) throws IOException;

    public Znamenitost getnewZarodysh(Igrok igrok , String vveli);

    public Vopros getRandowVopros(Igrok igrok) throws IOException;

    public void setZadanyiVopros(Igrok igrok ,int otvet);

    public void coretirovkaListVoposovDobalenyia(Igrok igrok);










}

