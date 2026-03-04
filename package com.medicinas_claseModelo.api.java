package com.medicinas.api.model;

public class Medicamento {
    
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    
    // MAL: No hay constructor
    // MAL: No hay validaciones en setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        // MAL: No validar null o vacío
        this.nombre = nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        // MAL: No validar precio negativo
        this.precio = precio;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        // MAL: No validar stock negativo
        this.stock = stock;
    }
}