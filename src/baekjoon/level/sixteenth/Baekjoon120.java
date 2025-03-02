package src.baekjoon.level.sixteenth;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon120 {

    private static Stack<Integer> myStack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        myStack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int menu = Integer.parseInt(st.nextToken());

            switch (menu) {
                case 1:
                    int item = Integer.parseInt(st.nextToken());
                    push(item);
                    break;
                case 2:
                    bw.write(pop() + "\n");
                    break;
                case 3:
                    bw.write(size() + "\n");
                    break;
                case 4:
                    bw.write(isEmpty() + "\n");
                    break;
                default:
                    bw.write(peek() + "\n");
                    break;
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void push(int num) {
        myStack.push(num);
    }
    private static int pop() {
        if (myStack.isEmpty()) return -1;
        else return myStack.pop();
    }
    private static int size() {
        return myStack.size();
    }
    private static int isEmpty() {
        if (myStack.isEmpty()) return 1;
        else return 0;
    }
    private static int peek() {
        if (myStack.isEmpty()) return -1;
        else return myStack.peek();
    }
}
