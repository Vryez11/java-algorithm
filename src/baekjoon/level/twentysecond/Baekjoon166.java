package src.baekjoon.level.twentysecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon166 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        long[] S = new long[N + 1];
        int[] mod = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            S[i] = S[i - 1] + arr[i];
            mod[(int) (S[i] % M)]++;
        }

        long ans = 0;
        for (int i = 0; i < M; i++) {
            int cnt = mod[i];

            if (i == 0) {
                ans += cnt;
            }

            if (cnt >= 2) {
                ans += (long) cnt * (cnt - 1) / 2;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
