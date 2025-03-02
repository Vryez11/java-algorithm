package src.baekjoon.level.sixteenth;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon125 {

    private static ArrayDeque<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String menu = st.nextToken();
            switch (menu) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");
                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                default:
                    bw.write(back() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void push(int num) {
        q.offer(num);
    }
    private static int pop() {
        if (q.isEmpty()) return -1;

        return q.poll();
    }
    private static int size() {
        return q.size();
    }
    private static int empty() {
        return q.isEmpty() ? 1 : 0;
    }
    private static int front() {
        if (q.isEmpty()) return -1;

        return q.peek();
    }
    private static int back() {
        if (q.isEmpty()) return -1;

        return q.getLast();
    }
}
