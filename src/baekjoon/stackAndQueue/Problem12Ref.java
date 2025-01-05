package src.baekjoon.stackAndQueue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem12Ref {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> mystack = new Stack<Integer>();
        mystack.push(0);
        for (int i = 1; i < N; i++) {
            while(!mystack.isEmpty() && A[mystack.peek()] < A[i]) {
                ans[mystack.pop()] = A[i];
            }
            mystack.push(i);
        }
        while (!mystack.empty()){
            ans[mystack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
