/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto;

import java.util.Scanner;

public class ImputNumbersExample {
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un número entero
        System.out.print("Ingresa un número entero: ");
        int numeroEntero = scanner.nextInt();

        // Solicitar al usuario que ingrese un número decimal
        System.out.print("Ingresa un número decimal: ");
        double numeroDecimal = scanner.nextDouble();

        // Solicitar al usuario que ingrese un número largo
        System.out.print("Ingresa un número largo: ");
        long numeroLargo = scanner.nextLong();

        // Realizar operaciones básicas con los números ingresados
        int suma = numeroEntero + (int) numeroLargo; // Casting de long a int para la suma
        double multiplicacion = numeroDecimal * numeroEntero;

        // Mostrar los resultados
        System.out.println("\nResultados:");
        System.out.println("Suma de " + numeroEntero + " y " + numeroLargo + " es: " + suma);
        System.out.println("Multiplicación de " + numeroDecimal + " y " + numeroEntero + " es: " + multiplicacion);

        // Cerrar el objeto Scanner
        scanner.close();
    }
}
