package src.baekjoon.level.eighth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beakjoon63 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        List<Integer> S = new ArrayList<>();
        S.add(7);
        while (S.get(S.size() - 1) < N) {
            S.add((S.size()) * 6 + 6 + S.get(S.size() - 1));
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(S.size() + 1);
    }
}
