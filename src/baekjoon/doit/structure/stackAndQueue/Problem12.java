package src.baekjoon.doit.structure.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = 0;
        int endIndex = startIndex + 1;

        while (startIndex < N) {
            if (startIndex == N-1) {
                sb.append(-1);
                break;
            }
            if (arr[startIndex] < arr[endIndex]) {
                sb.append(arr[endIndex]).append(" ");
                endIndex = ++startIndex + 1;
            } else {
                if (++endIndex >= N) {
                    endIndex = ++startIndex + 1;
                    sb.append(-1).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}
