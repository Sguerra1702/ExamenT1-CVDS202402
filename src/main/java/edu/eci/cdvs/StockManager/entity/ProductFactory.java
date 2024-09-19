package edu.eci.cdvs.StockManager.entity;

import edu.eci.cdvs.StockManager.entity.Product;
import edu.eci.cdvs.StockManager.entity.ProductCategory;
import edu.eci.cdvs.StockManager.entity.concrete.ProductAlimentos;
import edu.eci.cdvs.StockManager.entity.concrete.ProductTecnologia;
import edu.eci.cdvs.StockManager.entity.concrete.ProductRopa;
import edu.eci.cdvs.StockManager.entity.concrete.ProductElectrodomestico;
import edu.eci.cdvs.StockManager.entity.concrete.ProductHogar;

public class ProductFactory {

    public static Product create(ProductCategory category, int id, String nombre, int cantidadDisponible, String categoria){
        Product producto = null;
        switch (category){
            case tecnologia:
                producto = new ProductTecnologia(id, nombre, cantidadDisponible, categoria);
                break;
            case ropa:
                producto = new ProductRopa(id, nombre, cantidadDisponible, categoria);
                break;
            case alimentos:
                producto = new ProductAlimentos(id, nombre, cantidadDisponible, categoria);
                break;
            case electrodomestico:  
                producto = new ProductElectrodomestico(id, nombre, cantidadDisponible, categoria);
                break;
            case hogar:
                producto = new ProductHogar(id, nombre, cantidadDisponible, categoria);
                break;
            default:
                return null;
            }
        return producto;
    }
}
