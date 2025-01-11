package src.baekjoon.doit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem32 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coinCount = 0;
        int sum = 0;
        int[] A = new int[10];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int i = A.length - 1; i >= 0; i--) {
            while (sum < K) {
                sum += A[i];
                if (sum > K) {
                    sum -= A[i];
                    break;
                } else {
                    coinCount++;
                }
            }
        }
        System.out.println(coinCount);
    }
}
