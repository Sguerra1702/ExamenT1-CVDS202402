package edu.eci.cdvs.StockManager.service;

import org.springframework.stereotype.Service;

import edu.eci.cdvs.StockManager.entity.Product;

@Service
public class StockService {

    public void notificarAgentes(Product producto) {
        // Agente 1: Imprimir la cantidad disponible
        System.out.println("Producto: " + producto.getNombre() + " ->" + producto.getCantidadDisponible()+" Unidades disponibles.");

        // Agente 2: Generar alerta si hay menos de 5 unidades
        if (producto.getCantidadDisponible() < 5) {
            System.out.println("ALERTA!!!el stock del Producto: " + producto.getNombre() + "es muy bajo, solo quedan "+ producto.getCantidadDisponible()+" unidades.");
        }
    }
}
