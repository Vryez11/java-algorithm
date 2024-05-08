package src;

import src.programmers.Programmers8;
import src.programmers.Programmers9;
import src.programmers.Programmers10;
import src.programmers.Programmers11;
import src.programmers.Programmers12;
import src.programmers.Programmers13;

public class Example {
    public static void main(String[] args) {
        int[][] data = {{0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}};

        int[] moves = {1,5,3,5,1,2,1,4};

        int result = Programmers13.solution(data, moves);

        System.out.println("result = " + result);
    }
}
