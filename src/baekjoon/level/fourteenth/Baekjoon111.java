package src.baekjoon.level.fourteenth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon111 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String S = input.nextLine();
        Set<String> result = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j < S.length(); j++) {
                result.add(S.substring(i, j + 1));
            }
        }

        System.out.println(result.size());
    }
}
