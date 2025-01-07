package src.baekjoon.doit.mergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem21 {

    static int swapCount, N;
    static boolean changeCount;
    static int[] A, tempA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        swapCount = 0;
        changeCount = false;
        A = new int[N + 1];
        tempA = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(1, N);
        System.out.println(swapCount);
        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            tempA[i] = A[i];
        }
        int k = start;
        int index1 = start, index2 = mid + 1;
        changeCount = tempA[index2] < tempA[index1];
        boolean tempBool;
        while (index1 <= mid && index2 <= end) {
            if (tempA[index1] > tempA[index2]) {
                tempBool = false;
                if (end - start == 1) {
                    swapCount++;
                }
                A[k] = tempA[index2];
                k++;
                index2++;
            } else {
                tempBool = true;
                A[k] = tempA[index1];
                k++;
                index1++;
            }
            if (changeCount == tempBool) {
                if (end - start == 1) continue;
                swapCount += k - index1;
            } else {
                if (end - start == 1) continue;
                swapCount += index2 - k;

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
