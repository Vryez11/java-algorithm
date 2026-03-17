package src.programmers.lv2;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Problem86 problem86 = new Problem86();

        int solution = problem86.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30L);

        System.out.println("solution = " + solution);
    }
}
