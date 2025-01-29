package src.baekjoon.level.ninth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon70 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        br.close();

        int firstDia = 0;
        int diaSum = 0;

        int[] nums = new int[10001];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int i = 2; i < Math.sqrt(10000); i++) {
            if (nums[i] == i) {
                int count = 2;

                while (i * count <= nums.length - 1) {
                    if (nums[i * count] != - 1)
                        nums[i * count] = -1;
                    count++;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (nums[i] == i) {
                if (firstDia == 0) firstDia = i;
                diaSum += i;
            }
        }

        if (firstDia == 0) System.out.println(-1);
        else {
            System.out.println(diaSum);
            System.out.println(firstDia);
        }
    }
}
