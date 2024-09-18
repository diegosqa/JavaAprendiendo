/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

/**
 *
 * @author FAM-QA
 */
import org.jfree.data.category.DefaultCategoryDataset;

public class KMeansExecutor {

    public DefaultCategoryDataset executeKMeansWithThreads(int numClusters, int maxInit, int maxIter, double[][] data, int[] numThreadsArray) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int numThreads : numThreadsArray) {
            long executionTime = measureExecutionTime(numClusters, maxInit, maxIter, data, numThreads);
            System.out.println("Con " + numThreads + " hilos, tomó " + executionTime + "ms.");
            dataset.addValue(executionTime, "Tiempo de Ejecución", Integer.toString(numThreads));
        }

        return dataset;
    }

    private long measureExecutionTime(int numClusters, int maxInit, int maxIter, double[][] data, int numThreads) {
        long startTime = System.nanoTime();

        ParallelKMeansAlgo parallelKMeans = new ParallelKMeansAlgo(numClusters, maxInit, maxIter);
        parallelKMeans.fitWithThreads(data, numThreads);

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // Convertir a milisegundos
    }
}
