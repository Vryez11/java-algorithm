package src.baekjoon.doit.sort.mergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem21Ref {

    static long result;
    static int[] A, tempA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        result = 0;
        A = new int[N + 1];
        tempA = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);
        System.out.println(result);
        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            tempA[i] = A[i];
        }
        int k = start;
        int index1 = start, index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (tempA[index1] > tempA[index2]) {
                A[k] = tempA[index2];
                result += index2 - k;
                k++;
                index2++;
            } else {
                A[k] = tempA[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= mid) {
            A[k] = tempA[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            A[k] = tempA[index2];
            k++;
            index2++;
        }
    }
}
