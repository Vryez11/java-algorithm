package src.baekjoon.doit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem33 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long minSum = 0;
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        br.close();

        while(pq.size() > 1) {
            Long minNum1 = pq.poll();
            Long minNum2 = pq.poll();
            minSum += minNum1 + minNum2;
            pq.add(minNum1 + minNum2);
        }

        System.out.println(minSum);
    }
}
