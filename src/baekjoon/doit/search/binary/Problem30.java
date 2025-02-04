package src.baekjoon.doit.search.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        int[] S = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i - 1] + A[i];
        }
        int minSize = S[N] / M;
        int blueRayCount = 1;
        int startIndex = 1;
        int endIndex = 1;

        while (endIndex <= N) {
            if (S[endIndex] - S[startIndex - 1] <= minSize) {
                endIndex++;
            } else if (S[endIndex] - S[startIndex - 1] > minSize) {
                if (blueRayCount < M) {
                    blueRayCount++;
                    startIndex = endIndex;
                } else {
                    minSize++;
                    startIndex = 1;
                    endIndex = 1;
                    blueRayCount = 1;
                }
            }
        }

        br.close();
        System.out.println(minSize);
    }
}
