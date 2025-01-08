package src.baekjoon.doit.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem23 {

    private static ArrayList[] lists;
    private static boolean[] isChecked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 1;

        lists = new ArrayList[N + 1];
        isChecked = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            lists[end].add(start);
        }
        br.close();

        dfs(1);
        for (int i = 2; i <= N; i++) {
            if (!isChecked[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int nodIndex) {
        if (isChecked[nodIndex]) return;

        isChecked[nodIndex] = true;
        for (Object i : lists[nodIndex]) {
            if (!isChecked[(int) i])
                dfs((int) i);
        }
    }
}
