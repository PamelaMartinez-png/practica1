package com.upiiz.practica.Controller;

//Pamela Guadalupe Martinez Arteaga 2025670142
//Danna Elizama Arredondo Cordero 2025670102

public class Etiquetas {
    private String nombre;
    private String descripcion;
    private String sintaxis;
    private String atributos;
    private String ejemplo;

    public Etiquetas() {
    }

    public Etiquetas(String nombre, String descripcion, String sintaxis, String atributos, String ejemplo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sintaxis = sintaxis;
        this.atributos = atributos;
        this.ejemplo=ejemplo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSintaxis() {
        return sintaxis;
    }

    public void setSintaxis(String sintaxis) {
        this.sintaxis = sintaxis;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }
    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }
}
