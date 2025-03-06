package com.umbraudax.AlgoBook.Algorithms.Other;

public class BinaryOperations {
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
}
