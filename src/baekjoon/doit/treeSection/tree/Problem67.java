package src.baekjoon.doit.treeSection.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem67 {

    static int N;
    static boolean[] visited;
    static List<Integer>[] tree;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        br.close();

        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        for (Integer i : tree[node]) {
            if (!visited[i]) {
                answer[i] = node;
                DFS(i);
            }
        }
    }
}
