/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto;

/**
 *
 * @author FAM-QA
 */
public class ControlStructuresExample {
    public static void main(String[] args) {
        // 1. Estructura condicional if, else if, else
        int number = 10;

        System.out.println("Estructura condicional if, else if, else:");
        if (number > 0) {
            System.out.println("El número es positivo");
        } else if (number < 0) {
            System.out.println("El número es negativo");
        } else {
            System.out.println("El número es cero");
        }

        // 2. Estructura condicional switch
        int day = 3;
        System.out.println("\nEstructura condicional switch:");
        switch (day) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Día inválido");
        }

        // 3. Bucle while
        int count = 1;
        System.out.println("\nBucle while:");
        while (count <= 5) {
            System.out.println("Contador: " + count);
            count++;
        }

        // 4. Bucle do-while
        int doCount = 6;
        System.out.println("\nBucle do-while:");
        do {
            System.out.println("Contador: " + doCount);
            doCount++;
        } while (doCount <= 5);

        // 5. Bucle for
        System.out.println("\nBucle for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i: " + i);
        }

        // 6. Bucle for-each
        String[] fruits = {"Manzana", "Banana", "Cereza"};
        System.out.println("\nBucle for-each:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 7. Uso de break y continue
        System.out.println("\nUso de break y continue:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Salta el resto del bucle actual cuando i es 3
            }
            if (i == 4) {
                break; // Rompe el bucle cuando i es 4
            }
            System.out.println("i: " + i);
        }
    }
}
