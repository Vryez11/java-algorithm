package src.programmers.problems;

public class Programmers15 {

    public int solution(int[][] dots) {
        int answer = 0;

        if (gradient(dots[0], dots[1]) == gradient(dots[2], dots[3])) answer = 1;
        else if (gradient(dots[0], dots[2]) == gradient(dots[1], dots[3])) answer = 1;
        else if (gradient(dots[0], dots[3]) == gradient(dots[1], dots[2])) answer = 1;

        return answer;
    }

    private double gradient(int[] dot1, int[] dot2) {
        int x1 = dot1[0];
        int y1 = dot1[1];

        int x2 = dot2[0];
        int y2 = dot2[1];

        return ((double) Math.abs(x2 - x1)/Math.abs(y2 - y1));
    }
}
