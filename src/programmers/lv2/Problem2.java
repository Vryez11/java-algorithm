package src.programmers.lv2;

import java.util.Arrays;

public class Problem2 {
    //최솟값 만들기

    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int minSum = 0;

        for (int i = 0; i < A.length; i++) {
            minSum += A[i] * B[B.length - 1 -i];
        }

        return minSum;
    }
}
