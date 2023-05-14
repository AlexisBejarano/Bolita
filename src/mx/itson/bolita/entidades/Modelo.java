/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bolita.entidades;

import mx.itson.bolita.enumerador.STOCK;

/**
 *
 * @author medin
 */
public class Modelo {
    private int id;
    private String nombre;
    private double talla;
    private String color;
    private String marca;
    private STOCK strok;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the talla
     */
    public double getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(double talla) {
        this.talla = talla;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the strok
     */
    public STOCK getStrok() {
        return strok;
    }

    /**
     * @param strok the strok to set
     */
    public void setStrok(STOCK strok) {
        this.strok = strok;
    }
}
