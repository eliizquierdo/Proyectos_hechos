package modelo.dao;

import java.util.*;

import modelo.Producto;

public class ProductoDAO {
    private static List<Producto> productos = new ArrayList<>();
    private static int idActual = 1;

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Producto obtenerPorId(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void insertar(Producto p) {
        p.setId(idActual++);
        productos.add(p);
    }

    public void actualizar(Producto p) {
        Producto original = obtenerPorId(p.getId());
        if (original != null) {
            original.setNombre(p.getNombre());
            original.setPrecio(p.getPrecio());
        }
    }

    public void eliminar(int id) {
        productos.removeIf(p -> p.getId() == id);
    }
}