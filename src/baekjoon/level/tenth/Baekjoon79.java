package src.baekjoon.level.tenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon79 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();

        int[] lens = {a, b, c};
        Arrays.sort(lens);

        if (lens[2] >= lens[0] + lens[1] - 1) {
            System.out.println(2 * (lens[0] + lens[1]) - 1);
        } else {
            System.out.println(lens[0] + lens[1] + lens[2]);
        }
    }
}
