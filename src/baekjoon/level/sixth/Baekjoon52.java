package src.baekjoon.level.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon52 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (String word : words) {
            str = str.replaceAll(word, "1");
        }

        char[] strArray = str.toCharArray();
        int count = strArray.length;

        System.out.println(count);
    }
}
