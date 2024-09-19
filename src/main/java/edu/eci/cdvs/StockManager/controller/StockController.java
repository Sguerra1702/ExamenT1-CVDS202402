package edu.eci.cdvs.StockManager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.eci.cdvs.StockManager.entity.Product;
import edu.eci.cdvs.StockManager.entity.ProductFactory;
import edu.eci.cdvs.StockManager.entity.ProductMain;
import edu.eci.cdvs.StockManager.service.StockService;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestParam int id, @RequestParam String nombre, @RequestParam int cantidadDisponible, @RequestParam String categoria, @RequestParam int precio) {
        try {
            // Usamos el método createProduct de ProductMain
            Product producto = ProductMain.createProduct(id, nombre, cantidadDisponible, categoria, precio);
            productos.put(id, producto);
            return ResponseEntity.ok("Producto creado: " + producto.getNombre());
        } catch (IllegalArgumentException ex) {
            // Enviar una respuesta con código 400 si hay un error en la creación del producto
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
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
