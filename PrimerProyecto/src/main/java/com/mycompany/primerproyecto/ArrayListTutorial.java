/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTutorial {
    public static void main(String[] args) {
        // 1. Crear un ArrayList
        ArrayList<String> lista = new ArrayList<>();

        // 2. Agregar elementos al ArrayList
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        // 3. Acceder a un elemento en el ArrayList
        System.out.println("Elemento en índice 1: " + lista.get(1)); // Devuelve "Elemento 2"

        // 4. Modificar un elemento en el ArrayList
        lista.set(1, "Elemento Modificado");

        // 5. Eliminar un elemento por índice
        lista.remove(2); // Elimina "Elemento 3"

        // 6. Eliminar un elemento por valor
        lista.remove("Elemento Modificado"); // Elimina "Elemento Modificado"

        // 7. Verificar si un elemento existe en el ArrayList
        boolean existe = lista.contains("Elemento 1");
        System.out.println("¿Existe 'Elemento 1'?: " + existe); // Devuelve true

        // 8. Obtener el tamaño del ArrayList
        System.out.println("Tamaño del ArrayList: " + lista.size()); // Devuelve 1

        // 9. Recorrer el ArrayList usando un bucle for
        lista.add("Elemento 4");
        lista.add("Elemento 5");

        System.out.println("Recorriendo con bucle for:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Índice " + i + ": " + lista.get(i));
        }

        // 10. Recorrer el ArrayList usando un bucle for-each
        System.out.println("\nRecorriendo con bucle for-each:");
        for (String elemento : lista) {
            System.out.println(elemento);
        }

        // 11. Recorrer el ArrayList usando un Iterador
        System.out.println("\nRecorriendo con un Iterador:");
        Iterator<String> iterador = lista.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }

        // 12. Agregar todos los elementos de otra colección
        ArrayList<String> otraLista = new ArrayList<>();
        otraLista.add("Nuevo Elemento 1");
        otraLista.add("Nuevo Elemento 2");
        lista.addAll(otraLista); // Agrega todos los elementos de otraLista a lista

        System.out.println("\nDespués de agregar otra lista:");
        for (String elemento : lista) {
            System.out.println(elemento);
        }

        // 13. Obtener una sub-lista del ArrayList
        List<String> subLista = lista.subList(1, 3); // Devuelve una sub-lista desde el índice 1 hasta el 3 (no inclusivo)
        System.out.println("\nSub-lista:");
        for (String elemento : subLista) {
            System.out.println(elemento);
        }

        // 14. Convertir un ArrayList a un arreglo
        String[] arreglo = lista.toArray(new String[0]);
        System.out.println("\nArrayList convertido a arreglo:");
        for (String elemento : arreglo) {
            System.out.println(elemento);
        }

        // 15. Limpiar el ArrayList
        lista.clear();
        System.out.println("\nDespués de limpiar el ArrayList, tamaño: " + lista.size()); // Devuelve 0
    }
}

