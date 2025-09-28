package src.baekjoon.level.eighteenth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon136 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        Set<String> dancer = new HashSet<>();
        dancer.add("ChongChong");

        for (int i = 0; i < N; i++) {
            String a = input.next();
            String b = input.next();

            if (dancer.contains(a) || dancer.contains(b)) {
                dancer.add(a);
                dancer.add(b);
            }
        }

        System.out.println(dancer.size());
    }
}
