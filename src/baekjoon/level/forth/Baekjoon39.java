package src.baekjoon.level.forth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon39 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int[] arr = new int[42];
        for (int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine()) % 42]++;
        }
        br.close();

        for (int num : arr) {
            if (num != 0) count++;
        }

        System.out.println(count);
    }
}
