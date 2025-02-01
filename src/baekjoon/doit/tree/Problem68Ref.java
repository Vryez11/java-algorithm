package src.baekjoon.doit.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Problem68Ref {

    static List<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0;
    static int deleteNode = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        tree = new List[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new LinkedList<>();
        }
        int root = 0;
        for (int i = 0; i < N; i++) {
            int p = input.nextInt();
            if (p != - 1) {
                tree[p].add(i);
                tree[i].add(p);
            } else {
                root = i;
            }
        }
        deleteNode = input.nextInt();
        if (deleteNode == root) {
            System.out.println(0);
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        int cNode = 0;
        for (Integer next : tree[node]) {
            if (!visited[next] && next != deleteNode) {
                DFS(next);
                cNode++;
            }
        }
        if (cNode == 0) answer++;
    }
}
