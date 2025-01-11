package src.baekjoon.doit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem34Ref {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 1) {
                plusPq.add(tmp);
            } else if (tmp <= 0) {
                minusPq.add(tmp);
            } else {
                one++;
            }
        }
        br.close();

        int maxNum1, maxNum2;
        int sum = one;

        while (!plusPq.isEmpty()) {
            maxNum1 = plusPq.poll();
            if (plusPq.peek() == null) {
                sum += maxNum1;
                break;
            }
            maxNum2 = plusPq.poll();
            sum += maxNum1 * maxNum2;
        }
        while (!minusPq.isEmpty()) {
            maxNum1 = minusPq.poll();
            if (minusPq.peek() == null) {
                sum += maxNum1;
                break;
            }
            maxNum2 = minusPq.poll();
            sum += maxNum1 * maxNum2;
        }

        System.out.println(sum);
    }
}
