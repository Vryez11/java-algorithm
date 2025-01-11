package src.programmers.lv1;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Problem51 test = new Problem51();

        int N = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};

        int[] result = test.solution(N, stages);
        System.out.println(Arrays.toString(result));
    }
}
