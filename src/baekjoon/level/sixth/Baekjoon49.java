package src.baekjoon.level.sixth;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon49 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = {1, 1, 2, 2, 2, 8};
        int[] B = new int[6];
        int[] res = new int[6];

        for (int i = 0; i < 6; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            res[i] = A[i] - B[i];
            bw.write(res[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
