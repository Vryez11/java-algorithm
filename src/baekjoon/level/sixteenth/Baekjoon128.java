package src.baekjoon.level.sixteenth;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Baekjoon128 {

    private static ArrayDeque<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int menu = Integer.parseInt(st.nextToken());
            switch (menu) {
                case 1:
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    pushback(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    bw.write(poll() + "\n");
                    break;
                case 4:
                    bw.write(pop() + "\n");
                    break;
                case 5:
                    bw.write(size() + "\n");
                    break;
                case 6:
                    bw.write(empty() + "\n");
                    break;
                case 7:
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
        q.addFirst(num);
    }
    private static void pushback(int num) {
        q.addLast(num);
    }
    private static int poll() {
        if (q.isEmpty()) return -1;

        return q.removeFirst();
    }
    private static int pop() {
        if (q.isEmpty()) return -1;

        return q.removeLast();
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
