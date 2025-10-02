package src.baekjoon.level.nineteenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon143 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line.trim());
            int length = (int) Math.pow(3, N);

            char[] arr = new char[length];
            for (int i = 0; i < length; i++) {
                arr[i] = '-';
            }

            cantor(arr, 0, length);
            System.out.println(new String(arr));
        }
    }

    public static void cantor(char[] arr, int start, int length) {
        if (length == 1) return;
        int third = length / 3;

        for (int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' ';
        }

        cantor(arr, start, third);
        cantor(arr, start + 2 * third, third);
    }
}
