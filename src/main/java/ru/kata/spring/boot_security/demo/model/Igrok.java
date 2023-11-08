package ru.kata.spring.boot_security.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Igrok {

    String idKuki;

    List<Znamenitost> listVozmohVariantovSohibkami;

    List<Znamenitost> listVozmohnyhVariantov;

    List<Vopros>  listOstavshihsyaVoprosov;

    List<Vopros>  listPamyty = new ArrayList<>();

    Znamenitost znamenitostDobalenya; //todo дбавить в сущнось зародыш
    List<Vopros>  listVoprosovDlyaDobavlenyya; //todo дбавить в сущнось зародыш
    int schetchikDobavlenyh = 0; //todo дбавить в сущнось зародыш


   public int sizeDoVoprosa = 0;

   int shetchikProshenya = 0;


    public Igrok(String idKuki) {
        this.idKuki = idKuki;
    }

    public Igrok(String idKuki, List<Znamenitost> listVozmohnyhVariantov, List<Vopros> listOstavshihsyaVoprosov) {
        this.idKuki = idKuki;
        this.listVozmohnyhVariantov = listVozmohnyhVariantov;
        this.listOstavshihsyaVoprosov = listOstavshihsyaVoprosov;
    }

    boolean regimNapolnitel; // todo

    public Igrok(List<Znamenitost> listVozmohnyhVariantov, List<Vopros> listOstavshihsyaVoprosov) {
        this.listVozmohnyhVariantov = listVozmohnyhVariantov;
        this.listOstavshihsyaVoprosov = listOstavshihsyaVoprosov;
    }

    public String getIdKuki() {
        return idKuki;
    }

    public void setIdKuki(String idKuki) {
        this.idKuki = idKuki;
    }



    public List<Znamenitost> getListVozmohnyhVariantov() {
        return listVozmohnyhVariantov;
    }

    public void setListVozmohnyhVariantov(List<Znamenitost> listVozmohnyhVariantov) {
        this.listVozmohnyhVariantov = listVozmohnyhVariantov;
    }

    public List<Vopros> getListOstavshihsyaVoprosov() {
        return listOstavshihsyaVoprosov;
    }

    public void setListOstavshihsyaVoprosov(List<Vopros> listOstavshihsyaVoprosov) {
        this.listOstavshihsyaVoprosov = listOstavshihsyaVoprosov;
    }

    public List<Vopros> getListPamyty() {
        return listPamyty;
    }

    public void setListPamyty(Vopros vopros) {
        listPamyty.add(vopros);
    }


    public Znamenitost getZnamenitostDobalenya() {
        return znamenitostDobalenya;
    }

    public void setZnamenitostDobalenya(Znamenitost znamenitostDobalenya) {
        this.znamenitostDobalenya = znamenitostDobalenya;
    }


    public List<Vopros> getListVoprosovDlyaDobavlenyya() {
        return listVoprosovDlyaDobavlenyya;
    }

    public void setListVoprosovDlyaDobavlenyya(List<Vopros> listVoprosovDlyaDobavlenyya) {
        this.listVoprosovDlyaDobavlenyya = listVoprosovDlyaDobavlenyya;
    }

    public int getSchetchikDobavlenyh() {
        return schetchikDobavlenyh;
    }

    public void incrimentSchetchikDobavlenyh() {
        this.schetchikDobavlenyh++;
    }

    public void obnulenyeSchetchikDobavlenyh() {
        schetchikDobavlenyh=0;
    }

    @Override
    public String toString() {
        return "Igrok{" +
                "idKuki='" + idKuki + '\'' +
                ", listVozmohnyhVariantov=" + listVozmohnyhVariantov +
                ", listOstavshihsyaVoprosov=" + listOstavshihsyaVoprosov +
                ", listPamyty=" + listPamyty +
                ", znamenitostDobalenya=" + znamenitostDobalenya +
                ", listVoprosovDlyaDobavlenyya=" + listVoprosovDlyaDobavlenyya +
                ", schetchikDobavlenyh=" + schetchikDobavlenyh +
                ", regimNapolnitel=" + regimNapolnitel +
                '}';
    }

    public String toStringdebugsave() {
        return "Igrok{" +
                "idKuki='" + idKuki + '\'' +
                ", listPamyty=" + listPamyty +
                ", znamenitostDobalenya=" + znamenitostDobalenya +
                ", listVoprosovDlyaDobavlenyya=" + listVoprosovDlyaDobavlenyya +
                ", schetchikDobavlenyh=" + schetchikDobavlenyh +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Igrok)) return false;
        Igrok igrok = (Igrok) o;
        return Objects.equals(getIdKuki(), igrok.getIdKuki());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdKuki());
    }


    public List<Znamenitost> getListVozmohVariantovSohibkami() {
        return listVozmohVariantovSohibkami;
    }

    public void setListVozmohVariantovSohibkami(List<Znamenitost> listVozmohVariantovSohibkami) {
        this.listVozmohVariantovSohibkami = listVozmohVariantovSohibkami;
    }
}
