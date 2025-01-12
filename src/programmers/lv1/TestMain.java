package src.programmers.lv1;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Problem51 test = new Problem51();

        int N = 7;
        int[] stages = new int[]{8, 8, 8, 8, 8, 8, 8, 7, 4, 4, 2, 4, 1, 5, 6};

        int[] result = test.solution(N, stages);
        System.out.println(Arrays.toString(result));
    }
}
