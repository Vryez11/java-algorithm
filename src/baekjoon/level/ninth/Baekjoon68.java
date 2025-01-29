package src.baekjoon.level.ninth;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon68 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            int measureSum = 0;
            if (n == -1) break;

            list = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    measureSum += i;
                }
            }
            bw.write(n + " ");
            if (measureSum == n) {
                bw.write("= ");
                for (int j = 0; j < list.size(); j++) {
                    if (j == list.size() - 1) {
                        bw.write(list.get(j) + "\n");
                        continue;
                    }bw.write(list.get(j) + " + ");
                }
            } else {
                bw.write("is NOT perfect.\n");
            }
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
