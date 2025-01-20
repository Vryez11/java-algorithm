package src.baekjoon.doit.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem46 {

    private static int[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int count = 0;
        visited = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }
        br.close();

        BFS(X);

        for (int i = 1; i <= N; i++) {
            if (visited[i] == K + 1) {
                System.out.println(i);
                count++;
            }
            if (count == 0 && i == N)
                System.out.println(-1);
        }
    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startNode);
        visited[startNode] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer otherNode : graph[node]) {
                if(visited[otherNode] == 0) {
                    queue.add(otherNode);
                    visited[otherNode] = visited[node] + 1;
                }
            }
        }
    }
}
