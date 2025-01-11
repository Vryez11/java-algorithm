package src.baekjoon.doit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem34 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        PriorityQueue<Integer> resultPq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                pq1.add(tmp);
            } else {
                pq2.add(tmp);
            }
        }
        br.close();

        int maxNum1, maxNum2;
        int sum = 0;

        while (!pq1.isEmpty()) {
            maxNum1 = pq1.poll();
            if (pq1.peek() == null) {
                resultPq.add(maxNum1);
                break;
            }
            maxNum2 = pq1.poll();
            if (maxNum1 == 1 || maxNum2 == 1) {
                resultPq.add(maxNum1);
                resultPq.add(maxNum2);
            } else {
                resultPq.add(maxNum1 * maxNum2);
            }
        }
        while (!pq2.isEmpty()) {
            maxNum1 = pq2.poll();
            if (pq2.peek() == null) {
                resultPq.add(maxNum1);
                break;
            }
            maxNum2 = pq2.poll();
            resultPq.add(maxNum1 * maxNum2);
        }
        while(!resultPq.isEmpty()) {
            sum += resultPq.poll();
        }

        System.out.println(sum);
    }
}
