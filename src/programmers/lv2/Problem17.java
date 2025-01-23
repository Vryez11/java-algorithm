package src.programmers.lv2;

public class Problem17 {

    //예상 대진표
    public int solution(int n, int a, int b) {
        int gameFrequency = log2(n);
        int count = 0;
        int start = 1; int end = n;

        while (n > 1) {
            double mid = (double) (start + end) / 2;
            if ((a < mid && b > mid) || (a > mid && b < mid)) {
                break;
            }
            count++;
            n /= 2;
            if (a < mid && b < mid) {
                end = (int) mid;
            } else {
                start = (int) (mid + 1);
            }
        }

        return gameFrequency - count;
    }

    private int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}