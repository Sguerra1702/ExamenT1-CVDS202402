package edu.eci.cdvs.StockManager.entity.concrete;

import edu.eci.cdvs.StockManager.entity.Product;

public class ProductTecnologia implements Product{
    private int id;
    private String nombre;
    private int precio;
    private int cantidadDisponible;
    private String categoria;

    public ProductTecnologia(int id, String nombre,int precio, int cantidadDisponible, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    @Override
    public int getPrecio() {
        return precio;
    }
}
