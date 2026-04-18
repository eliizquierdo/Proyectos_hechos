package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Ejercicio 1: Clase Dispositivo
class Dispositivo {
    private int numeroSerie;
    private String marca;
    private double precioFabricacion;

    public Dispositivo(int numeroSerie, String marca, double precioFabricacion) {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.precioFabricacion = precioFabricacion;
    }

    public int getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(int numeroSerie) { this.numeroSerie = numeroSerie; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public double getPrecioFabricacion() { return precioFabricacion; }
    public void setPrecioFabricacion(double precioFabricacion) { this.precioFabricacion = precioFabricacion; }

    public double precioVenta() {
        if (precioFabricacion > 500) {
            return precioFabricacion * 1.15;
        } else {
            return precioFabricacion * 0.95;
        }
    }

    @Override
    public String toString() {
        return "Dispositivo { " + "Numero de Serie: " + numeroSerie + ", Marca: " + marca + ", Precio de Venta: " + precioVenta() + " }";
    }
}

