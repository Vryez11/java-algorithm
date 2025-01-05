package src.baekjoon.bufferedPractice;

import java.io.*;

public class BaekP1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(br.readLine() + "??!\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
