package src.baekjoon.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem12ReSolve {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        sb.append(-1).append(" ");
        int tempMax = stack.pop();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (tempMax > temp) sb.append(tempMax).append(" ");
            else sb.append(-1).append(" ");

            if (!stack.isEmpty())
                if (temp > stack.peek()) tempMax = temp;
        }
        String str = sb.toString();

        String[] split = str.split(" ");
        for (int i = split.length - 1; i > 0; i--) {
            System.out.print(Integer.parseInt(split[i]) + " ");
        }
        System.out.print(Integer.parseInt(split[0]));
    }
}

