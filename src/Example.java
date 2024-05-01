package src;

import src.programmers.Programmers8;

public class Example {
    public static void main(String[] args) {
        Programmers8 solution = new Programmers8();
        String[] terms = {"Z 12"};
        String[] privacies = {"2019.01.01 Z"};

        int[] result = {};

        result = solution.solution("2020.01.01", terms, privacies);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
