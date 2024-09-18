/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

/**
 *
 * @author FAM-QA
 */
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ForkJoinPool;
import java.util.Arrays;
import static java.util.concurrent.ForkJoinTask.invokeAll;

public class ParallelKMeansAlgo {

    private int k;
    private int maxInit;
    private int maxIter;
    private double WCSS;
    private double[][] data;
    private int rows;
    private int cols;
    private double[] maxCol;
    private double[] minCol;
    private int[] assignments;
    private double[][] centroids;

    public ParallelKMeansAlgo(int k, int maxInit, int maxIter) {
        this.k = k;
        this.maxInit = maxInit;
        this.maxIter = maxIter;
    }

    public void fitWithThreads(double[][] data, int numThreads) {
        initializeData(data);

        ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);
        double bestWCSS = Double.MAX_VALUE;
        double[][] bestCentroids = new double[k][cols];
        int[] bestAssignments = new int[rows];

        for (int init = 0; init < maxInit; init++) {
            placeInitialCentroids();
            WCSS = Double.MAX_VALUE;

            double prevWCSS;
            int iter = maxIter;
            do {
                forkJoinPool.invoke(new KMeansTask(0, rows));
                updateCentroids();
                prevWCSS = WCSS;
                calculateWCSS();
                iter--;
            } while (iter > 0 && isSignificantImprovement(prevWCSS));

            if (WCSS < bestWCSS) {
                bestWCSS = WCSS;
                bestCentroids = deepCopy(centroids);
                bestAssignments = Arrays.copyOf(assignments, assignments.length);
            }
        }

        WCSS = bestWCSS;
        centroids = bestCentroids;
        assignments = bestAssignments;
    }

    private void initializeData(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
        this.assignments = new int[rows];
        this.centroids = new double[k][cols];
        this.maxCol = new double[cols];
        this.minCol = new double[cols];

        Arrays.fill(maxCol, Double.MIN_VALUE);
        Arrays.fill(minCol, Double.MAX_VALUE);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxCol[j] = Math.max(maxCol[j], data[i][j]);
                minCol[j] = Math.min(minCol[j], data[i][j]);
            }
        }
    }

    private void placeInitialCentroids() {
        for (int i = 0; i < k; i++) {
            placeInitialCentroid(i);
        }
    }

    private void placeInitialCentroid(int clusterInd) {
        for (int i = 0; i < cols; i++) {
            double rand = minCol[i] + ThreadLocalRandom.current().nextDouble() * (maxCol[i] - minCol[i]);
            centroids[clusterInd][i] = Math.round(rand * 10.0) / 10.0;
        }
    }

    private class KMeansTask extends RecursiveAction {

        private static final int THRESHOLD = 1000;
        private final int start;
        private final int end;

        public KMeansTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) <= THRESHOLD) {
                assignPointsToCentroids(start, end);
            } else {
                int mid = (start + end) / 2;
                invokeAll(new KMeansTask(start, mid), new KMeansTask(mid, end));
            }
        }

        private void assignPointsToCentroids(int start, int end) {
            for (int i = start; i < end; i++) {
                assignments[i] = findClosestCentroid(data[i]);
            }
        }
    }

    private int findClosestCentroid(double[] point) {
        double minDist = Double.MAX_VALUE;
        int closestCentroid = 0;

        for (int j = 0; j < k; j++) {
            double dist = euclideanDistance(point, centroids[j]);
            if (dist < minDist) {
                minDist = dist;
                closestCentroid = j;
            }
        }
        return closestCentroid;
    }

    private void updateCentroids() {
        for (double[] centroid : centroids) {
            Arrays.fill(centroid, 0);
        }

        int[] centroidCounts = new int[k];

        for (int i = 0; i < rows; i++) {
            int cluster = assignments[i];
            centroidCounts[cluster]++;
            for (int j = 0; j < cols; j++) {
                centroids[cluster][j] += data[i][j];
            }
        }

        for (int i = 0; i < k; i++) {
            if (centroidCounts[i] != 0) {
                for (int j = 0; j < cols; j++) {
                    centroids[i][j] /= centroidCounts[i];
                }
            } else {
                placeInitialCentroid(i);
            }
        }
    }

    private void calculateWCSS() {
        WCSS = 0;
        for (int i = 0; i < rows; i++) {
            WCSS += distance(data[i], centroids[assignments[i]]);
        }
    }

    private boolean isSignificantImprovement(double prevWCSS) {
        double diff = Math.abs(prevWCSS - WCSS);
        return diff > Math.abs(WCSS / 1000.0);
    }

    private double[][] deepCopy(double[][] original) {
        double[][] copy = new double[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }

    private static double distance(double[] x, double[] y) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i] - y[i], 2);
        }
        return sum;
    }

    private static double euclideanDistance(double[] x, double[] y) {
        return Math.sqrt(distance(x, y));
    }

    public int[] getAssignments() {
        return assignments;
    }

    public double getWCSS() {
        return WCSS;
    }

    public double[][] getCentroids() {
        return centroids;
    }
}
