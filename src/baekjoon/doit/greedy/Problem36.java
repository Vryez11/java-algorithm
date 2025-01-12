package src.baekjoon.doit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem36 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] minusSplit = str.split("-");
        int[] arr = new int[minusSplit.length];
        int sum = 0;
        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            for (String s : plusSplit) {
                arr[i] += Integer.parseInt(s);
            }
            if (i == 0) sum += arr[i];
            else sum -= arr[i];
        }

        System.out.println(sum);
    }
}
