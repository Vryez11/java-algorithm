package src.baekjoon.level.sixteenth;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon127 {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = input.nextInt();
        int K = input.nextInt();
        int count = 1;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        bw.write("<");
        if (N == 1) {
            bw.write("1>");
            bw.flush();
            bw.close();
            return;
        }
        while (!q.isEmpty()) {

            if (count % K == 0) {
                bw.write(q.poll() + ", ");
            }
            else {
                q.offer(q.poll());
            }
            if (q.size() == 1) {
                bw.write(q.poll() + ">");
            }

            count++;
        }
        bw.flush();
        bw.close();
    }
}
