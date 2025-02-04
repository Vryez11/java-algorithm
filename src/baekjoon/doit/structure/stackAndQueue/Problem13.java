package src.baekjoon.doit.structure.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem13 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            myQueue.add(i);
        }

        while(myQueue.size() > 1) {
            if (count % 2 == 0) {
                myQueue.poll();
            } else {
                myQueue.add(myQueue.poll());
            }
            count++;
        }
        System.out.println(myQueue.peek());
    }
}
