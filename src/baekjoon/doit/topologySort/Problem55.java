package src.baekjoon.doit.topologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem55 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<dNode>[] A = new ArrayList[N + 1];
        ArrayList<dNode>[] reverseA = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            reverseA[i] = new ArrayList<>();
        }
        int[] indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            A[S].add(new dNode(E, V));
            reverseA[E].add(new dNode(S, V));
            indegree[E]++;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : A[now]) {
                indegree[next.targetNode]--;
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if (indegree[next.targetNode] == 0) {
                    queue.offer(next.targetNode);
                }
            }
        }

        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(endNode);
        visited[endNode] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : reverseA[now]) {
                if (result[next.targetNode] + next.value == result[now]) {
                    resultCount++;
                    if (!visited[next.targetNode]) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[endNode]);
        System.out.println(resultCount);
    }

    private static class dNode {
        private int targetNode;
        private int value;

        public dNode(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
