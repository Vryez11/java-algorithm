package src.baekjoon.level.sixth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon54 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double score = 0L; double credit = 0L;

        for (int i = 0; i < 20; i++) {
            String[] grades = br.readLine().split(" ");
            double tempScore = Double.parseDouble(grades[1]) * changeScore(grades[2]);
            if (tempScore >= 0) {
                score += tempScore;
                credit += Double.parseDouble(grades[1]);
            }
        }

        br.close();
        System.out.println(score / credit);
    }

    private static double changeScore(String grade) {
        switch (grade) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            case "P":
                return -1;
            default:
                return -1;
        }
    }
}
