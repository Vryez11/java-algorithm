package src.programmers.lv1;

import java.util.Arrays;

public class Problem7 {

    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        int arrCnt = 0;

        for (int num : arr) {
            if (num % divisor == 0) count++;
        }

        if (count == 0) {
            int[] answer = {-1};
            return answer;
        }
        else {
            int[] answer = new int[count];

            for (int num : arr) {
                if (num % divisor == 0) answer[arrCnt++] = num;
            }

            Arrays.sort(answer);

            return answer;
        }
    }
}
