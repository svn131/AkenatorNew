package ru.kata.spring.boot_security.demo.model;

import java.util.List;

public class Igrok {

    String idKuki;

    List<Znamenitost> listVozmohnyhVariantov;

    List<Vopros>  listOstavshihsyaVoprosov;

   int zaddanyiVopros;


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

    public int getZaddanyiVopros() {
        return zaddanyiVopros;
    }

    public void setZaddanyiVopros(int zaddanyiVopros) {
        this.zaddanyiVopros = zaddanyiVopros;
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

    @Override
    public String toString() {
        return "Igrok{" +
                "idKuki='" + idKuki + '\'' +
                ", listVozmohnyhVariantov=" + listVozmohnyhVariantov +
                ", listOstavshihsyaVoprosov=" + listOstavshihsyaVoprosov +
                ", zaddanyiVopros=" + zaddanyiVopros +
                ", regimNapolnitel=" + regimNapolnitel +
                '}';
    }
}
