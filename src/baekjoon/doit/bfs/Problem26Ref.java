package src.baekjoon.doit.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem26Ref {

    private static boolean[] visitedDFS;
    private static boolean[] visitedBFS;
    private static ArrayList<Integer>[] A;
    private static Queue<Integer> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N + 1];
        visitedBFS = new boolean[N + 1];
        Q = new LinkedList<>();
        A = new ArrayList[N + 1];
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
        System.out.println();
        bfs(V);
    }

    private static void dfs(int V) {
        System.out.print(V + " ");
        visitedDFS[V] = true;

        for (Integer num : A[V]) {
            if (!visitedDFS[num])
                dfs(num);
        }
    }

    private static void bfs(int V) {
        Q.add(V);
        visitedBFS[V] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();
            System.out.print(now + " ");
            for (Integer num : A[now]) {
                if (!visitedBFS[num]){
                    visitedBFS[num] = true;
                    Q.add(num);
                }
            }
        }
    }
}
