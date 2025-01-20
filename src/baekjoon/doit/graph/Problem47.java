package src.baekjoon.doit.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem47 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = Arrays.stream(answer).max().getAsInt();
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max)
                System.out.print(i + " ");
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer nextNode : graph[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    answer[nextNode]++;
                    queue.add(nextNode);
                }
            }
        }
    }
}
