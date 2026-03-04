package com.medicinas.api.test;

import com.medicinas.api.service.MedicamentoService;

public class TestSimple {
    
    public static void main(String[] args) {
        
        MedicamentoService service = new MedicamentoService();
        
        // Agregar medicamentos
        service.agregarMedicamento("Paracetamol", 5.99, 100);
        service.agregarMedicamento("Ibuprofeno", 8.50, 50);
        service.agregarMedicamento("Amoxicilina", 12.75, 30);
        
        // Buscar (problemas aquí)
        service.buscarPorNombre(null); // Causará NullPointerException
        
        // Mostrar resultados
        System.out.println("Total medicamentos: " + service.obtenerTodos().size());
        
        // Calcular inventario
        double valor = service.calcularValorInventario();
        System.out.println("Valor total: $" + valor);
    }
}