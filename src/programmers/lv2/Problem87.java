package src.programmers.lv2;

public class Problem87 {

    // 멀쩡한 사각형
    public long solution(int w, int h) {
        long W = w;
        long H = h;

        int gcd = gcd(w, h);

        return W * H - (W + H - gcd);
    }

    private int gcd(int a, int b) {
        if (b % a == 0) return a;

        return gcd(b % a, a);
    }
}
