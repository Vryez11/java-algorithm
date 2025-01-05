package src;

import src.programmers.problems.Programmers14;

public class Example {
    public static void main(String[] args) {
        Programmers14 programmers14 = new Programmers14();

        int[] data = {0,0};
        String hand = "right";

        String result = programmers14.solution(data, hand);

        System.out.println("result = " + result);
    }
}
