package Algorithms.Searching;

public class BasicSearching {
    public static <T extends Comparable<T>> int linearSearch(T[] A, T x) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }
}
