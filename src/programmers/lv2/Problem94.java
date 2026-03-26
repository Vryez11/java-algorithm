package src.programmers.lv2;

public class Problem94 {

    // 점 찍기
    public long solution(int k, int d) {
        long answer = 0L;

        long y = d - (d % k);
        long dd = (long) d * d;

        for (long x = 0; x <= d; x += k) {
            while (x * x + y * y > dd) {
                y -= k;
            }
            answer += y / k + 1;
        }

        return answer;
    }
}
