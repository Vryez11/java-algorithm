package src.baekjoon.doit.sort.radixSort;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem22 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        radixSort(A);
        for (int num : A) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void radixSort(int[] arr) {
        Queue<Integer>[] jarisuQueue = new Queue[10];
        for (int i = 0; i < 10; i++) {
            jarisuQueue[i] = new LinkedList<>();
        }

        int maxNum = Arrays.stream(arr).max().getAsInt();
        int maxDigit = (int) Math.log10(maxNum) + 1;

        int jarisu = 1;
        for (int i = 0; i < maxDigit; i++) {
            for (int num : arr) {
                int digit = (num / jarisu) % 10;
                jarisuQueue[digit].add(num);
            }

            int index = 0;
            for (Queue<Integer> queue : jarisuQueue) {
                while (!queue.isEmpty()) {
                    arr[index++] = queue.poll();
                }
            }

            jarisu *= 10;
        }
    }
}
