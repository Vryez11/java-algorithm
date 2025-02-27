package src.baekjoon.level.fourteenth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon107 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        Map<String, Integer> sMap = new HashMap<>();
        Map<Integer, String> iMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemon = input.next();

            sMap.put(pokemon, i);
            iMap.put(i, pokemon);
        }

        for (int i = 1; i <= M; i++) {
            if (input.hasNextInt()) {
                System.out.println(iMap.get(input.nextInt()));
            } else {
                System.out.println(sMap.get(input.next()));
            }
        }
    }
}
