/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto;

public class DataTypesExample {
    public static void main(String[] args) {
        // 1. Tipos Primitivos
        byte byteVar = 100;         // 8 bits
        short shortVar = 30000;     // 16 bits
        int intVar = 100000;        // 32 bits
        long longVar = 10000000000L;// 64 bits
        float floatVar = 5.75f;     // 32 bits
        double doubleVar = 19.99;   // 64 bits
        boolean booleanVar = true;  // true o false
        char charVar = 'A';         // Carácter Unicode

        // 2. Imprimir valores de tipos primitivos
        System.out.println("Tipos Primitivos:");
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("boolean: " + booleanVar);
        System.out.println("char: " + charVar);

        // 3. Tipos de Referencia - String
        String stringVar = "Hola, Java!";
        System.out.println("\nTipo de Referencia - String:");
        System.out.println("String: " + stringVar);

        // 4. Tipos de Referencia - Array
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println("\nTipo de Referencia - Array:");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Elemento en índice " + i + ": " + intArray[i]);
        }

        // 5. Clases Wrapper para Tipos Primitivos
        Integer integerWrapper = 100;
        Double doubleWrapper = 55.55;

        System.out.println("\nClases Wrapper:");
        System.out.println("Integer Wrapper: " + integerWrapper);
        System.out.println("Double Wrapper: " + doubleWrapper);

        // 6. Ejemplo de Conversión entre Tipos
        double doubleValue = intVar; // Conversión Implícita
        int intValue = (int) doubleVar; // Conversión Explícita

        System.out.println("\nConversión entre Tipos:");
        System.out.println("Conversión Implícita (int a double): " + doubleValue);
        System.out.println("Conversión Explícita (double a int): " + intValue);
    }
}
