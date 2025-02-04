package src.baekjoon.doit.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem31 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        br.close();

        long start = 1, end = k, ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            int n = 1;
            int count = 0;

            while (n <= N) {
                count += Math.min(N, mid / n);
                n++;
            }

            if (count < k) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
