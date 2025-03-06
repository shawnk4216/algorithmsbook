package com.umbraudax.AlgoBook.Algorithms;

import com.umbraudax.AlgoBook.Algorithms.Sorting.BasicSorting;
import com.umbraudax.AlgoBook.Algorithms.Other.BinaryOperations;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BasicTest {
    public static final Random RAND = new Random();
    public static final int TEST_SEQ_LENGTH = 1000;

    // Testing functions

    public static void testInsertionSort(Integer[] A) {
        A = (A == null) ? generateRandomSeq(TEST_SEQ_LENGTH) : A;


        System.out.println("--- INSERTION SORT ---");
        System.out.println("Not sorted");
        printArray(A);
        long t1 = System.currentTimeMillis();
        BasicSorting.insertionSort(A);
        long t2 = System.currentTimeMillis();
        System.out.println("Sorted");
        printArray(A);
        System.out.println("Is Sorted?: " + isSorted(A));
        System.out.println("Elapsted Time: " + (t2 - t1) + " ms");
        System.out.println();
    }

    public static void testRInsertionSort(Integer[] A) {
        A = (A == null) ? generateRandomSeq(TEST_SEQ_LENGTH) : A;

        System.out.println("--- RECURSIVE INSERTION SORT ---");
        System.out.println("Not sorted");
        printArray(A);
        long t1 = System.currentTimeMillis();
        BasicSorting.rInsertionSort(A, A.length);
        long t2 = System.currentTimeMillis();
        System.out.println("Sorted");
        printArray(A);
        System.out.println("Is Sorted?: " + isSorted(A));
        System.out.println("Elapsted Time: " + (t2 - t1) + " ms");
        System.out.println();
    }

    public static void testSelectionSort(Integer[] A) {
        A = (A == null) ? generateRandomSeq(TEST_SEQ_LENGTH) : A;

        System.out.println("--- SELECTION SORT ---");
        System.out.println("Not sorted");
        printArray(A);
        long t1 = System.currentTimeMillis();
        BasicSorting.selectionSort(A);
        long t2 = System.currentTimeMillis();
        System.out.println("Sorted");
        printArray(A);
        System.out.println("Is Sorted?: " + isSorted(A));
        System.out.println("Elapsted Time: " + (t2 - t1) + " ms");

        System.out.println();
    }

    public static void testMergeSort(Integer[] A) {
        A = (A == null) ? generateRandomSeq(TEST_SEQ_LENGTH) : A;

        System.out.println("--- MERGE SORT ---");
        System.out.println("Not sorted");
        printArray(A);
        long t1 = System.currentTimeMillis();
        BasicSorting.mergeSort(A, 0, A.length - 1);
        long t2 = System.currentTimeMillis();
        System.out.println("Sorted");
        printArray(A);
        System.out.println("Is Sorted?: " + isSorted(A));
        System.out.println("Elapsted Time: " + (t2 - t1) + " ms");
        System.out.println();

    }

    public static void testBinaryAdd() {
        int[] A = {1, 0, 0, 0, 1, 1, 1, 0, 1, 0};
        int[] B = {0, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        int[] C = BinaryOperations.addBinaryIntegers(A, B);
        printArray(boxIntArray(A));
        printArray(boxIntArray(B));
        printArray(boxIntArray(C));
    }

    // Utility functions

    public static Integer[] generateRandomSeq(int n) {
        IntStream intStream = RAND.ints(n);
        return intStream.boxed().toArray(Integer[]::new);
    }

    public static <T> void printArray(T[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static Integer[] boxIntArray(int[] A) {
        return Arrays.stream(A).boxed().toArray(Integer[]::new);
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i].compareTo(A[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    // Execution

    public static void main(String[] args) {
        var A1 = generateRandomSeq(TEST_SEQ_LENGTH);
        var A2 = Arrays.copyOf(A1, TEST_SEQ_LENGTH);
        var A3 = Arrays.copyOf(A1, TEST_SEQ_LENGTH);
        var A4 = Arrays.copyOf(A1, TEST_SEQ_LENGTH);
        testInsertionSort(A1);
        testRInsertionSort(A2);
        testSelectionSort(A3);
        testMergeSort(A4);

    }
}
