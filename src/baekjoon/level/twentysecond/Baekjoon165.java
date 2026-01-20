package src.baekjoon.level.twentysecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon165 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();
        char[] arr = S.toCharArray();
        int n = arr.length;

        int[][] pre = new int[26][n + 1];

        for (int i = 0; i < n; i++) {
            int col = arr[i] - 'a';
            for (int k = 0; k < 26; k++) {
                pre[k][i + 1] = pre[k][i];
            }
            pre[col][i + 1]++;
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int col = ch - 'a';
            sb.append(pre[col][r + 1] - pre[col][l]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
