package src.baekjoon.level.fourteenth;

import java.util.*;

public class Baekjoon109 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();

        Set<String> set = new HashSet<>();
        TreeSet<String> result = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set.add(input.next());
        }
        for (int i = 0; i < M; i++) {
            String name = input.next();

            if (set.contains(name)) {
                result.add(name);
            }
        }

        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}
