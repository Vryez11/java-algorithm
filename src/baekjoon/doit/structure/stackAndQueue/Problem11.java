package src.baekjoon.doit.structure.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem11 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int naturalCount = 0;
        int[] squence = new int[N];
        int[] natural = new int[N];

        for (int i = 0; i < N; i++) {
            squence[i] = Integer.parseInt(br.readLine());
            natural[i] = i + 1;
        }

        for (int i = 0; i < N; i++) {
            while (squence[i] >= natural[naturalCount]) {
                stack.push(natural[naturalCount]);
                sb.append("+\n");
                naturalCount++;
                if (naturalCount >= N) {
                    naturalCount = N - 1;
                    break;
                }
            }
            if (squence[i] == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        br.close();
        System.out.println(sb);
    }
}
