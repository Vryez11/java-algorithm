package src;

import src.programmers.Programmers7;

public class Example {
    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        Programmers7 solution = new Programmers7();

        int[] answer = solution.solution(park, routes);
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
