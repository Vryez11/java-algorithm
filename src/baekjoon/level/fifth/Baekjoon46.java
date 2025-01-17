package src.baekjoon.level.fifth;

import java.io.*;

public class Baekjoon46 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        br.close();
        String alphaString = "abcdefghijklmnopqrstuvwxyz";
        char[] alphaArray = alphaString.toCharArray();
        for (char alpha : alphaArray) {
            bw.write(S.indexOf(alpha) + " ");
        }

        bw.flush();
        bw.close();
    }
}
