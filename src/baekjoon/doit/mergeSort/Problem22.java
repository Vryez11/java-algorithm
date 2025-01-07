package src.baekjoon.doit.mergeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem22 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int maxDigit = 0;
        int whileCount = 0;
        int count, tmp;
        for (int i = 0; i < N; i++) {
            count = 1;
            A[i] = Integer.parseInt(br.readLine());
            tmp = A[i];
            while (tmp / 10 != 0) {
                count++;
                tmp /= 10;
            }
            maxDigit = Math.max(maxDigit, count);
        }
        PriorityQueue<Integer>[] myQueue= new PriorityQueue[10];

        for (int i = 0; i < 10; i++) {
            myQueue[i] = new PriorityQueue<>();
        }

        while (whileCount < maxDigit) {
            int indexCount = 0;

            if (whileCount == 0) {
                for (int i = 0; i < N; i++) {
                    myQueue[A[i] % 10].add(A[i]);
                }
            } else {
                for (int i = 0; i < N; i++) {
                    myQueue[(A[i] / (int) Math.pow(10, whileCount)) % 10].add(A[i]);
                }
            }

            for (int i = 0; i < 10; i++) {
                while (!myQueue[i].isEmpty()) {
                    A[indexCount] = myQueue[i].poll();
                    indexCount++;
                }
            }
            whileCount++;
        }

        for (int num : A) {
            System.out.println(num);
        }
    }
}
