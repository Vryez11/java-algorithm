package src.baekjoon.doit.structure.arraylist;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[] scores = new double[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }
        double maxScore = Arrays.stream(scores).max().getAsDouble();
        double sum = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = scores[i] / maxScore * 100;
            sum += scores[i];
        }

        System.out.println(sum / N);
    }
}
