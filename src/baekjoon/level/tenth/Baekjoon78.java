package src.baekjoon.level.tenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon78 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] lens = new int[3];

        while(true) {
            st = new StringTokenizer(br.readLine());

            lens[0] = Integer.parseInt(st.nextToken());
            lens[1] = Integer.parseInt(st.nextToken());
            lens[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(lens);
            if (lens[2] == 0) break;

            if (lens[2] < lens[0] + lens[1]) {
                if (lens[0] == lens[1] && lens[0] == lens[2]) {
                    System.out.println("Equilateral");
                } else if (lens[0] == lens[1] || lens[0] == lens[2] || lens[1] == lens[2]) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
