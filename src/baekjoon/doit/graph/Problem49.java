package src.baekjoon.doit.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem49 {

    private static int[] Sender = {0, 0, 1, 1, 2, 2};
    private static int[] Reciver = {1, 2, 0, 2, 0, 1};
    static boolean visited[][];
    static boolean[] answer;
    static int[] now;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        now = new int[3];
        now[0] = Integer.parseInt(st.nextToken());
        now[1] = Integer.parseInt(st.nextToken());
        now[2] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201];
        answer = new boolean[201];
        br.close();
        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS() {
        Queue<AB> queue = new ArrayDeque<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;
        while (!queue.isEmpty()) {
            AB p = queue.poll();
            int A = p.A;
            int B = p.B;
            int C = now[2] - A - B;
            for (int k = 0; k < 6; k++) {
                int[] next = {A, B, C};
                next[Reciver[k]] += next[Sender[k]];
                next[Sender[k]] = 0;
                if (next[Reciver[k]] > now[Reciver[k]]) {
                    next[Sender[k]] = next[Reciver[k]] - now[Reciver[k]];
                    next[Reciver[k]] = now[Reciver[k]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            A = a;
            B = b;
        }
    }

}
