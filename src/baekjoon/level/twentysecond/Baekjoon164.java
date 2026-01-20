package src.baekjoon.level.twentysecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon164 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long ans = Integer.MIN_VALUE;

        int[] arr = new int[N + 1];
        long[] S = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        br.close();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i - 1] + arr[i];
        }

        for (int i = K; i <= N; i++) {
            ans = Math.max(ans, S[i] - S[i - K]);
        }

        System.out.println(ans);
    }
}
