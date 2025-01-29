package src.programmers.lv2;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Problem28 problem = new Problem28();

        int[] solution = problem.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(solution));
    }
}
