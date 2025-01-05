package src.baekjoon.bufferedPractice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterMain {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("hello, world!");
        bw.newLine();
        bw.write("this is a BufferedWriter example.");
        bw.flush();

        bw.close();
    }
}
