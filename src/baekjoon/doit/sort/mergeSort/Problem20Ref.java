package src.baekjoon.doit.sort.mergeSort;

import java.io.*;

public class Problem20Ref {

    static int[] A;
    static int[] tempA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tempA = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);

        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1)
            return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            tempA[i] = A[i];
        }
        int k = start;
        int index1 = start;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (tempA[index1] > tempA[index2]) {
                A[k] = tempA[index2];
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
