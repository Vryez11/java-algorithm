package src.baekjoon.level.fifteenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon114 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        br.close();

        int resultA = B1 * A2 + B2 * A1;
        int resultB = B1  * B2;

        int gcd = gcd(resultA, resultB);

        System.out.println(resultA / gcd + " " + resultB / gcd);
    }

    private static int gcd(int a, int b) {
        if (b % a == 0) return a;

        return gcd(b, a % b);
    }
}
