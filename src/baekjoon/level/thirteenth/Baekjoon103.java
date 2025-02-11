package src.baekjoon.level.thirteenth;

import java.io.*;
import java.util.*;

public class Baekjoon103 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for (int i = 0; i < N; i++) {
            set.add(A[i]);
        }

        int[] B = new int[set.size()];
        int indexB = 0;
        for (Integer num : set) {
            B[indexB] = num;
            indexB++;
        }

        Arrays.sort(B);

        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(A[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
