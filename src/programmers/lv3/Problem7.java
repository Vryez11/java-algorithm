package src.programmers.lv3;

import java.util.Arrays;

public class Problem7 {

    // 숫자 게임
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int idxA = 0;
        int idxB = 0;
        int answer = 0;

        while (idxA < A.length && idxB < B.length) {

            if (A[idxA] >= B[idxB]) {
                idxB++;
                continue;
            }

            if (A[idxA] < B[idxB]) {
                idxA++;
                idxB++;
                answer++;
            }
        }

        return answer;
    }
}
