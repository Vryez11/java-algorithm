package src.baekjoon.level.ThirdLevel;

import java.io.*;

public class Baekjoon26 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int forNum = Integer.parseInt(bf.readLine());

        for (int i = 0; i < forNum; i++) {
            String[] input = bf.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            bw.write(String.valueOf(a + b)); // 숫자를 문자열로 변환하여 쓰기
            bw.newLine();
        }

        bw.close();
    }
}