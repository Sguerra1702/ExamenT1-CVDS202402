package edu.eci.cdvs.StockManager.controller;

import org.springframework.web.bind.annotation.*;

import edu.eci.cdvs.StockManager.entity.Product;
import edu.eci.cdvs.StockManager.service.StockService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class StockController {

    private Map<Integer, Product> productos = new HashMap<>();
    private final StockService notificacionService;

    public StockController(StockService notificacionService) {
        this.notificacionService = notificacionService;
    }

    // Agregar un nuevo producto
    @PostMapping
    public Product agregarProducto(@RequestBody Product producto) {
        productos.put(producto.getId(), producto);
        return producto;
    }

    // Actualizar la cantidad de un producto
    @PutMapping("/{id}")
    public Product actualizarProducto(@PathVariable int id, @RequestBody int nuevaCantidad) {
        Product producto = productos.get(id);
        if (producto != null) {
            producto.setCantidadDisponible(nuevaCantidad);
            productos.put(id, producto);

            // Notificar a los agentes
            notificacionService.notificarAgentes(producto);
        }
        return producto;
    }

    // Obtener todos los productos
    @GetMapping
    public Map<Integer, Product> obtenerProductos() {
        return productos;
    }
}