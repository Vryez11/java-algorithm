package src.baekjoon.doit.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem29 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            System.out.println(binary_search(0, arr.length - 1,Integer.parseInt(st.nextToken())));
        }
    }

    private static int binary_search(int start, int end, int value) {
        if (end - start <= 1) {
            if (arr[start] == value) {
                return 1;
            } else if (arr[end] == value) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == value) {
            return 1;
        } else if (arr[mid] > value) {
            return binary_search(start, mid - 1, value);
        } else {
            return binary_search(mid + 1, end, value);
        }
    }
}
