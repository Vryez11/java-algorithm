package src.baekjoon.doit.search.bfs;


import java.util.*;

public class Problem28 {

    private static boolean visited[];
    private static int[] distance;
    private static ArrayList<Node>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1)
                    break;
                int V = sc.nextInt();
                A[S].add(new Node(E, V));
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);
        int Max = 1;
        for (int i = 2; i <= N;i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Node node : A[now_node]) {
                int E = node.index;
                int V = node.distance;
                if (!visited[E]) {
                    visited[E] = true;
                    queue.add(E);
                    distance[E] = distance[now_node] + V;
                }
            }
        }
    }

    private static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
