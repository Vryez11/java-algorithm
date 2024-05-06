package src;

import src.programmers.Programmers8;
import src.programmers.Programmers9;
import src.programmers.Programmers10;
import src.programmers.Programmers11;

public class Example {
    public static void main(String[] args) {
        String[] surveys = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choises = {5, 3, 2, 7, 5};
        String result = Programmers11.solution(surveys, choises);

        System.out.println("result = " + result);
    }
}
