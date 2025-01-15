package src.baekjoon.doit.extendedeuclidean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem45 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int gcd = gcd(A, B);
        if (C % gcd != 0) {
            System.out.println(-1);
        } else {
            int mok = C / gcd;
            long[] ret = Excute(A, B);
            System.out.println(ret[0] * mok + " " + ret[1] * mok);
        }
    }

    private static long[] Excute(int a, int b) {
        long[] ret = new long[2];
        if (b == 0) {
            ret[0] = 1; ret[1] = 0;
            return ret;
        }
        long q = a / b;
        long[] v = Excute(b, a % b);
        ret[0] = v[1];
        ret[1] = v[0] - v[1] * q;
        return ret;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else return gcd(b, a % b);
    }
}
