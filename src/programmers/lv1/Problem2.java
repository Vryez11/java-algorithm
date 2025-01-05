package src.programmers.lv1;

public class Problem2 {

    public long solution(int a, int b) {
        long answer = 0;

        if (b >= a) {
            for (int k = a; k <= b; k++) {
                answer += k;
            }
        } else {
            for (int k = b; k <= a; k++) {
                answer += k;
            }
        }

        return answer;
    }
}
