package src.programmers.lv1;

public class Problem1 {
    public int solution(int n) {
        int answer = 0;
        int num = 1;

        while (n >= num) {
            if (n % num == 0) answer += num;
            num++;
        }

        return answer;
    }
}
