package Algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class BasicAlgos {
    public static final Random RAND = new Random();
    public static final int TEST_SEQ_LENGTH = 1000;

    public static Integer[] generateRandomSeq(int n) {
        IntStream intStream = RAND.ints(n);
        return intStream.boxed().toArray(Integer[]::new);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] A) {
        int n = A.length; // gets length of the array
        for (int i = 1; i < n; i++) { // loop through all values in the array besides the first element (sorted by default)
            T key = A[i]; // get value at the array
            int j = i - 1; // start sliding through sorted elements (right before current element)
            while (j >= 0 && A[j].compareTo(key) > 0) { // go through sorted elements until 1. at beginning of sorted elements to be put first 2. found element that is less than or equal to itself
                A[j + 1] = A[j]; // shift elements (get ready to insert) (A[i] will be replaced but value was banked already)
                j = j - 1; // update current sorted element
            }
            A[j + 1] = key; // place element at determined spot
        }
    }

    public static <T extends Comparable<T>> void insertionSortDec(T[] A) {
        int n = A.length;
        for (int i = n - 2; i >= 0; i--) {
            T key = A[i];
            int j = i + 1;
            while (j <= n - 1 && A[j].compareTo(key) > 0) {
                A[j - 1] = A[j];
                j = j + 1;
            }
            A[j - 1] = key;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            T minValue = A[i];
            for (int j = i + 1; j < n; j++) {
                if (A[j].compareTo(minValue) < 0) {
                    minValue = A[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T elem = A[i];
                A[i] = A[minIndex];
                A[minIndex] = elem;
            }
        }
    }

    public static <T extends Comparable<T>> int linearSearch(T[] A, T x) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public static int[] addBinaryIntegers(int[] A, int[] B) throws IllegalArgumentException {
        if (A.length != B.length) {
            throw new IllegalArgumentException("A and B arrays must have the same length");
        }
        int n = A.length;
        int carry = 0;
        int[] C = new int[n + 1];
        for (int i = 0; i < n; i++) {
            C[i] = A[i] + B[i] + carry;
            carry = 0;
            if (C[i] > 1) {
                carry = 1;
                C[i] -= 2;
            }
        }
        C[n] = carry;
        return C;
    }

    // Testing functions

    public static void testInsertionSort() {
        var A = generateRandomSeq(TEST_SEQ_LENGTH);

        System.out.println("Not sorted");
        printArray(A);
        insertionSort(A);
        System.out.println("Sorted");
        printArray(A);
    }

    public static void testSelectionSort() {
        var A = generateRandomSeq(TEST_SEQ_LENGTH);

        System.out.println("Not sorted");
        printArray(A);
        selectionSort(A);
        System.out.println("Sorted");
        printArray(A);
    }

    public static void testBinaryAdd() {
        int[] A = {1, 0, 0, 0, 1, 1, 1, 0, 1, 0};
        int[] B = {0, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        int[] C = addBinaryIntegers(A, B);
        printArray(boxIntArray(A));
        printArray(boxIntArray(B));
        printArray(boxIntArray(C));
    }

    // Utility functions

    public static <T> void printArray(T[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static Integer[] boxIntArray(int[] A) {
        return Arrays.stream(A).boxed().toArray(Integer[]::new);
    }

    // Execution

    public static void main(String[] args) {
        testInsertionSort();
    }
}
