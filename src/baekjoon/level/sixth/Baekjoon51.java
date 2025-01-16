package src.baekjoon.level.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon51 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        br.close();

        StringBuilder sb1 = new StringBuilder(str.substring(0, str.length() / 2));
        StringBuilder sb2 = new StringBuilder(sb1);
        char mid = str.charAt(str.length() / 2);

        if (str.length() % 2 == 0) {
            sb2.append(sb1.reverse());
            if (sb2.toString().equals(str)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            sb2.append(mid).append(sb1.reverse());
            if (sb2.toString().equals(str)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
