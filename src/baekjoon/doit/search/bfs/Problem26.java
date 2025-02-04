package src.baekjoon.doit.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem26 {

    private static boolean[] visitedDFS;
    private static boolean[] visitedBFS;
    private static int[] dfsChannel;
    private static int[] bfsChannel;
    private static ArrayList<Integer>[] A;
    private static Queue<Integer> Q;
    private static int dfsCount;
    private static int bfsCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N + 1];
        visitedBFS = new boolean[N + 1];
        dfsChannel = new int[N + 1];
        bfsChannel = new int[N + 1];
        Q = new LinkedList<>();
        A = new ArrayList[N + 1];
        dfsCount = 1;
        bfsCount = 1;
        for (int i = 0; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        br.close();

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        dfs(V);
        bfs(V);

        for (int i = 1; i < dfsChannel.length; i++) {
            System.out.print(dfsChannel[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < bfsChannel.length; i++) {
            System.out.print(bfsChannel[i] + " ");
        }
    }

    private static void dfs(int V) {
        if (A[V].isEmpty() || visitedDFS[V]) return;

        visitedDFS[V] = true;

        for (Integer num : A[V]) {
            if (!visitedDFS[num])
                dfs(num);
        }
    }

    private static void bfs(int V) {
        Q.add(V);
        visitedBFS[V] = true;
        Q.poll();

        do {
            bfsChannel[bfsCount] = V;
            bfsCount++;

            for (Integer num : A[V]) {
                if (!visitedBFS[num]) {
                    visitedBFS[num] = true;
                    Q.add(num);
                }
            }

            if (!Q.isEmpty()) {
                V = Q.poll();
            }
        } while (!Q.isEmpty());

        bfsChannel[bfsCount] = V;
    }
}
