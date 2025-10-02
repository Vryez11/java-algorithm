package src.baekjoon.level.nineteenth;

import java.io.*;
import java.util.*;

public class Baekjoon142 {

    static List<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);

        if (list.size() < K) {
            System.out.println(-1);
            return;
        }

        System.out.println(list.get(K - 1));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int m = (start + end) / 2;
            mergeSort(arr, start, m);
            mergeSort(arr, m + 1, end);
            merge(arr, start, m, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int s = start;
        int m = mid + 1;
        int t = 0;
        int[] tmp = new int[end - start + 1];

        while (s <= mid && m <= end) {
            if (arr[s] <= arr[m]) {
                tmp[t++] = arr[s++];
            } else {
                tmp[t++] = arr[m++];
            }
        }

        while (s <= mid) {
            tmp[t++] = arr[s++];
        }
        while (m <= end) {
            tmp[t++] = arr[m++];
        }

        s = start;
        t = 0;

        while (s <= end) {
            list.add(tmp[t]);
            arr[s++] = tmp[t++];
        }
    }
}