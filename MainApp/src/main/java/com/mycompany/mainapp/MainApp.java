/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp;

/**
 *
 * @author FAM-QA
 */
public class MainApp {
    public static void main(String[] args) {
        // Parámetros del algoritmo
        int numPoints = 1000000; // Número de puntos a generar
        int numClusters = 8;    // Número de clusters
        int maxInit = 100;       // Número máximo de inicializaciones
        int maxIter = 100;      // Número máximo de iteraciones

        // Generar datos aleatorios bidimensionales (x, y)
        double[][] data = DataUtils.generateRandomData(numPoints, 2);

        // Números de hilos a probar
        int[] numThreadsArray = {1, 2, 4, 8, 16};

        // Ejecutar el algoritmo K-means y recopilar los resultados
        KMeansExecutor kMeansExecutor = new KMeansExecutor();
        var dataset = kMeansExecutor.executeKMeansWithThreads(numClusters, maxInit, maxIter, data, numThreadsArray);

        // Crear la gráfica y mostrarla en pantalla
        var lineChart = ChartUtils.createChart(dataset);
        ChartUtils.showChart(lineChart, "Gráfica: Hilos vs Tiempo de Ejecución");
    }
}
