package src.baekjoon.level.sixteenth;

import java.io.*;
import java.util.*;

public class Baekjoon129 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.offer(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            sb.append(current[0]).append(" ");

            if (dq.isEmpty()) break;

            int step = current[1];
            if (step > 0) {
                for (int i = 1; i < step; i++) {
                    dq.offer(dq.poll());
                }
            } else {
                for (int i = 0; i < Math.abs(step); i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}
