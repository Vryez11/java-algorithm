package src.baekjoon.doit.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem25 {

    private static ArrayList<Integer>[] myLists;
    private static boolean[] visited;
    private static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = false;
        myLists = new ArrayList[N ];
        for (int i = 0; i < N; i++) {
            myLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            myLists[a].add(b);
            myLists[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 0);
            if (result) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static void dfs(int node, int depth) {
        depth++;
        visited[node] = true;

        if (depth == 5){
            result = true;
            return;
        }

        for (Integer num : myLists[node]) {
            if (!visited[num]) {
                dfs(num, depth);
            }
        }

        visited[node] = false;
    }
}
