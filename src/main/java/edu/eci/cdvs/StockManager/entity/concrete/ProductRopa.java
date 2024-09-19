package edu.eci.cdvs.StockManager.entity.concrete;

import edu.eci.cdvs.StockManager.entity.Product;

public class ProductRopa implements Product{
    private int id;
    private String nombre;
    private int cantidadDisponible;
    private String categoria;

    public ProductRopa(int id, String nombre, int cantidadDisponible, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.categoria = categoria;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    @Override
    public void setCantidadDisponible(int cantidad) {
        this.cantidadDisponible = cantidad;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }
}
