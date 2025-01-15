package src.programmers.lv1;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Problem63 test = new Problem63();

        int[] arr = {1, 2, 1, 2, 3, 1, 3, 1};

        int result = test.solution(arr);
        System.out.println("result = " + result);
    }
}
