package src.programmers.lv1;

public class Problem38 {

    public int solution(int a, int b, int n) {
        int bottleCount = 0;
        int bottleRe = 0;
        int div;

        while (n / a > 0) {
            bottleRe = 0;
            div = n / a;
            if (div != 0) {
                bottleCount += div * b;
                bottleRe += div * b;
                bottleRe += n % a;
                n = bottleRe;
            }
        }

        return bottleCount;
    }
}
