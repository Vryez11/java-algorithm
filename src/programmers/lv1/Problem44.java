package src.programmers.lv1;

public class Problem44 {

    public int solution(int number, int limit, int power) {
        int[] solders = new int[number + 1];
        int res = 0;

        for (int i = 1; i <= number; i++) {
            solders[i] = divisor(i);
            if (solders[i] > limit) res += power;
            else res += solders[i];
        }

        return res;
    }

    private int divisor(int num) {
        int count = 0;

        for (int i = 1; i <= num /2; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        return count + 1;
    }
}
