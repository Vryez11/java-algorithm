package src.programmers.lv1;

public class Problem48 {

    public int solution(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count += isDecimal(i);
        }

        return count;
    }

    private int isDecimal(int n) {
        int count = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0)
                count++;
        }
        return count > 1 ? 0 : 1;
    }
}
