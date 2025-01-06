package src.baekjoon.doit.insertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19Resolve {

    static private int[]A;
    static private int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);
        System.out.println(A[K-1]);

        br.close();

    }

    private static void quickSort(int start, int end){
        int pivot = partition(start, end);
        if (pivot == K - 1) return;
        else if (pivot > K - 1) quickSort(start, pivot - 1);
        else quickSort(pivot + 1, end);
    }

    private static int partition(int start, int end) {
        if (start + 1 == end) {
            if (A[start] > A[end]) swap(start, end);
            return end;
        }
        int M = (start + end) / 2;
        swap(start, M);
        int pivot = A[start];
        int i = start + 1, j = end;
        while (i <= j) {
            while (j >= start + 1 && pivot < A[j]) {
                j--;
            }
            while (i <= end && pivot > A[i]) {
                i++;
            }
            if (i <= j) {
                swap(i++, j--);
            }
        }

        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    private static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
