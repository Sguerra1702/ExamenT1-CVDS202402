package edu.eci.cdvs.StockManager.entity;


public interface Product {
    public int getId();
    public String getNombre();
    public int getCantidadDisponible();
    public void setCantidadDisponible(int cantidad);
    public String getCategoria();
}

