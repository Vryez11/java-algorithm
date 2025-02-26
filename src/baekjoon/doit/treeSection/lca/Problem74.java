package src.baekjoon.doit.treeSection.lca;

import java.util.*;

public class Problem74 {

    static List<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int s = input.nextInt();
            int e = input.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);
        int M = input.nextInt();
        for (int i = 0; i < M; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int LCA = excuteLCA(a, b);
            System.out.println(LCA);
        }
    }

    private static int excuteLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Integer next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node;
                    depth[next] = level;
                }
            }

            count++;
            if (count == now_size) {
                count = 0;
                now_size = queue.size();
                level++;
            }
        }
    }
}
