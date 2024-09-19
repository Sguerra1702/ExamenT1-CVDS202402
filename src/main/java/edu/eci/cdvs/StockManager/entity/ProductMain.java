package edu.eci.cdvs.StockManager.entity;

public class ProductMain {
    public static void main(String[] args) {
        if(args == null || args.length != 5){
            System.out.println("Error: se requieren parámetros para crear un producto");
            return;
        }
        try{
            int id = Integer.parseInt(args[0]);
            String nombre = args[1];
            int cantidadDisponible = Integer.parseInt(args[2]);
            String categoria = args[3];
            int precio = Integer.parseInt(args[4]);
            ProductCategory category = ProductCategory.valueOf(categoria);
            Product product = ProductFactory.create(category, id, nombre, precio, cantidadDisponible, categoria);
            System.out.println("Producto creado: " + product.getNombre());
        }
        catch (IllegalArgumentException ex){
            System.out.println("Error: No se puede crear el producto con estos parámetros");
        }
    }

}
