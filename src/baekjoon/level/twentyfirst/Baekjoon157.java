package src.baekjoon.level.twentyfirst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon157 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cur = Integer.parseInt(st.nextToken());
        int ans = cur;

        for (int i = 2; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            cur = Math.max(x, cur + x);
            ans = Math.max(ans, cur);
        }

        System.out.println(ans);
    }
}
