/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTutorial {
    public static void main(String[] args) {
        // 1. Crear un HashMap
        HashMap<Integer, String> mapa = new HashMap<>();

        // 2. Agregar pares clave-valor al HashMap
        mapa.put(1, "Valor 1");
        mapa.put(2, "Valor 2");
        mapa.put(3, "Valor 3");

        // 3. Acceder a un valor en el HashMap
        String valor = mapa.get(2); // Devuelve "Valor 2"
        System.out.println("El valor asociado a la clave 2 es: " + valor);

        // 4. Modificar un valor en el HashMap
        mapa.put(2, "Valor Modificado");

        // 5. Eliminar un par clave-valor del HashMap
        mapa.remove(3); // Elimina el par con la clave 3

        // 6. Verificar si una clave o valor existe
        boolean existeClave = mapa.containsKey(1); // true
        boolean existeValor = mapa.containsValue("Valor 1"); // true
        System.out.println("¿Existe la clave 1?: " + existeClave);
        System.out.println("¿Existe el valor 'Valor 1'?: " + existeValor);

        // 7. Obtener el tamaño del HashMap
        System.out.println("El tamaño del HashMap es: " + mapa.size());

        // 8. Recorrer el HashMap usando un bucle for-each para las claves
        System.out.println("\nRecorriendo con bucle for-each (claves):");
        for (Integer clave : mapa.keySet()) {
            System.out.println("Clave: " + clave + ", Valor: " + mapa.get(clave));
        }

        // 9. Recorrer el HashMap usando un bucle for-each para las entradas
        System.out.println("\nRecorriendo con bucle for-each (entradas):");
        for (Map.Entry<Integer, String> entrada : mapa.entrySet()) {
            System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }

        // 10. Recorrer el HashMap usando un Iterador
        System.out.println("\nRecorriendo con un Iterador:");
        Iterator<Map.Entry<Integer, String>> iterador = mapa.entrySet().iterator();
        while (iterador.hasNext()) {
            Map.Entry<Integer, String> entrada = iterador.next();
            System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }

        // 11. Limpiar el HashMap
        mapa.clear();
        System.out.println("\nDespués de limpiar el HashMap, tamaño: " + mapa.size()); // Devuelve 0
    }
}
