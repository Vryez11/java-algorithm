package src.baekjoon.level.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem41 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        System.out.println(S.charAt(Integer.parseInt(br.readLine()) - 1));
        br.close();
    }
}
