/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

/**
 *
 * @author FAM-QA
 */
import java.util.stream.IntStream;

public class DataUtils {
    
    // Método para generar datos aleatorios
    public static double[][] generateRandomData(int numPoints, int numDimensions) {
        double[][] data = new double[numPoints][numDimensions];
        IntStream.range(0, numPoints).forEach(i -> {
            for (int j = 0; j < numDimensions; j++) {
                data[i][j] = Math.random() * 100;  // Valores en el rango [0, 100)
            }
        });
        return data;
    }
}
