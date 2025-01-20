package src.baekjoon.doit.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem48 {

    private static ArrayList<Integer>[] graph;
    private static int[] check;
    private static boolean[] visited;
    private static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 1; j <= E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }

            for (int j = 1; j <= V; j++) {
                if (isEven)
                    DFS(j);
                else
                    break;
            }

            System.out.println(isEven ? "YES" : "NO");
            br.close();
        }
    }

    private static void DFS (int v) {
        visited[v] = true;

        for (int i : graph[v]) {
            if (!visited[i]) {
                check[i] = (check[v] + 1) % 2;
                DFS(i);
            }
            else if (check[v] == check[i]) {
                isEven = false;
            }
        }
    }
}
