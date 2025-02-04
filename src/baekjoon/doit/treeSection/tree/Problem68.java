package src.baekjoon.doit.treeSection.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem68 {

    private static List<Integer>[] tree;
    private static boolean[] visited;
    private static boolean[] marked;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int rootNode = 0;
        result = 0;
        visited = new boolean[N];
        marked = new boolean[N];
        tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == - 1) {
                rootNode = i;
                continue;
            }
            tree[parentNode].add(i);
        }
        int deleteNode = Integer.parseInt(br.readLine());
        br.close();

        DeleteBFS(deleteNode);
        if (!marked[rootNode]) {
            BFS(rootNode);
        }

        System.out.println(result);
    }

    private static void DeleteBFS (int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            marked[now] = true;
            for (Integer next : tree[now]) {
                queue.add(next);
            }
            tree[now].clear();
        }
    }
    private static void BFS (int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            if (marked[now]) continue;

            visited[now] = true;
            int childCount = 0;
            for (Integer next : tree[now]) {
                if (!visited[next] && !marked[next]) {
                    queue.add(next);
                    childCount++;
                }
            }
            if (childCount == 0) result++;
        }
    }
}
