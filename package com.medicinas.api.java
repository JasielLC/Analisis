package com.medicinas.api.service;

import com.medicinas.api.model.Medicamento;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Servicio para gestionar medicamentos
 */
public class MedicamentoService {
    
    private static List<Medicamento> medicamentos = new ArrayList<>();
    private static int contador = 0;
    
    // MAL: Logger no es estático ni final
    private Logger logger = Logger.getLogger("MedicamentoService");
    
    /**
     * Agrega un nuevo medicamento
     */
    public void agregarMedicamento(String nombre, double precio, int stock) {
        // MAL: No validación de parámetros
        Medicamento m = new Medicamento();
        m.setId(++contador);
        m.setNombre(nombre);
        m.setPrecio(precio);
        m.setStock(stock);
        
        medicamentos.add(m);
        logger.info("Medicamento agregado: " + nombre);
    }
    
    /**
     * Busca medicamentos por nombre
     */
    public List<Medicamento> buscarPorNombre(String nombre) {
        // MAL: Posible NullPointerException si nombre es null
        List<Medicamento> resultados = new ArrayList<>();
        
        for (int i = 0; i < medicamentos.size(); i++) { // MAL: Usar for-each sería mejor
            Medicamento m = medicamentos.get(i);
            
            // MAL: Comparación incorrecta, sensible a mayúsculas
            if (m.getNombre() == nombre) { // ERROR: Debe usar equals()
                resultados.add(m);
            }
        }
        
        return resultados;
    }
    
    /**
     * Actualiza el stock de un medicamento
     */
    public boolean actualizarStock(int id, int nuevoStock) {
        boolean encontrado = false;
        
        for (int i = 0; i < medicamentos.size(); i++) {
            Medicamento m = medicamentos.get(i);
            
            if (m.getId() == id) {
                // MAL: No validar stock negativo
                m.setStock(nuevoStock);
                encontrado = true;
                break;
            }
        }
        
        // MAL: Código muerto, nunca se ejecuta
        if (!encontrado) {
            System.out.println("No encontrado"); // MAL: Usar System.out en lugar de logger
            return false;
        }
        
        return encontrado;
    }
    
    /**
     * Obtiene todos los medicamentos
     */
    public List<Medicamento> obtenerTodos() {
        // MAL: Expone la referencia interna
        return medicamentos; // Debe retornar una copia
    }
    
    /**
     * Calcula el valor total del inventario
     */
    public double calcularValorInventario() {
        double total = 0;
        
        for (Medicamento m : medicamentos) {
            total = total + (m.getPrecio() * m.getStock()); // OK, pero se puede mejorar
        }
        
        // MAL: División por cero si no hay medicamentos
        double promedio = total / medicamentos.size(); // Error si lista vacía
        
        try {
            // MAL: Código innecesario
            int x = 10 / 0; // Esto siempre lanza excepción
        } catch (ArithmeticException e) {
            // MAL: No hacer nada con la excepción
        }
        
        return total;
    }
    
    /**
     * Método con complejidad ciclomática alta
     */
    public String clasificarMedicamento(double precio, int stock, boolean esControlado) {
        // MAL: Múltiples if-else anidados (complejidad alta)
        if (precio > 0) {
            if (precio < 10) {
                if (stock > 100) {
                    if (esControlado) {
                        return "Económico controlado con stock alto";
                    } else {
                        return "Económico no controlado con stock alto";
                    }
                } else {
                    if (esControlado) {
                        return "Económico controlado con stock bajo";
                    } else {
                        return "Económico no controlado con stock bajo";
                    }
                }
            } else {
                // Más anidamientos...
                return "Caro";
            }
        } else {
            return "Precio inválido";
        }
    }
}