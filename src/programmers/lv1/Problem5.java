package src.programmers.lv1;

public class Problem5 {

    public long solution(long n) {
        long answer = -1;
        long num = 1;

        while (num*num <= n) {
            if (num * num == n) return (num + 1) * (num + 1);
            else num++;
        }

        return answer;
    }
}
