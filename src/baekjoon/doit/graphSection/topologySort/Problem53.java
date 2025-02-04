package src.baekjoon.doit.graphSection.topologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem53 {

    private static List<Integer>[] students;
    private static int[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        edges = new int[N + 1];
        students = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            students[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            students[A].add(B);
            edges[B]++;
        }
        br.close();

        int start = 1;
        while (queue.size() < N) {
            if (edges[start] == 0) {
                queue.offer(start);
                for (Integer i : students[start]) {
                    edges[i]--;
                }
                edges[start] = -1;
            }
            start++;
            if (start > N) {
                start = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : queue) {
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
