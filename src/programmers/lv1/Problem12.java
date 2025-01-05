package src.programmers.lv1;

import java.util.Arrays;

public class Problem12 {

    public int[] solution(int[] arr) {
        int arrLength = arr.length;

        if (arrLength == 1) return new int[] {-1};
        int[] answer = new int[arrLength- 1];
        int answerCount = 0;
        int min = Arrays.stream(arr).min().getAsInt();

        for (int i = 0; i < arrLength; i++) {
            if (arr[i] > min) {
                answer[answerCount] = arr[i];
                answerCount++;
            }
        }

        return answer;
    }
}
