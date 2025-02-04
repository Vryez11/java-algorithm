package src.baekjoon.doit.graphSection.topologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem54 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degree = new int[N + 1];
        int[] result = new int[N + 1];
        int[] time = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            while (value != -1) {
                graph[value].add(i);
                degree[i]++;
                value = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                result[i] = time[i];
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Integer building : graph[now]) {
                degree[building]--;
                result[building] = Math.max(result[building], result[now] + time[building]);

                if (degree[building] == 0) {
                    queue.add(building);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}
