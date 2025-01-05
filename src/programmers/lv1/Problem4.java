package src.programmers.lv1;

import java.util.Arrays;

public class Problem4 {

    public long solution(long n) {
        long answer = 0;

        String strAnswer = n + "";
        String[] stringAnswer = strAnswer.split("");
        Arrays.parallelSort(stringAnswer);

        int answerLength = stringAnswer.length;
        for (int i = 0; i < answerLength; i++) {
            answer += (long) (Long.parseLong(stringAnswer[i])*(Math.pow(10, i)));
        }

        return answer;
    }
}
