package src.programmers.lv3;

public class Problem20 {

    public long solution(int[] sequence) {

        long answer = Long.MIN_VALUE;

        long dp1 = 0;
        long dp2 = 0;

        for (int i = 0; i < sequence.length; i++) {
            long pulse = (i % 2 == 0) ? 1 : -1;

            long num1 = sequence[i] * pulse;
            long num2 = sequence[i] * -pulse;

            dp1 = Math.max(num1, dp1 + num1);
            dp2 = Math.max(num2, dp2 + num2);

            answer = Math.max(answer, Math.max(dp1, dp2));
        }

        return answer;
    }
}
