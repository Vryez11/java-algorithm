package src.programmers.lv2;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {

        Problem91 problem91 = new Problem91();
        String[] solution = problem91.solution(new String[][]{{"korean", "12:10", "30"}, {"english", "11:40", "20"}});
        System.out.println("solution = " + solution);
    }
}
