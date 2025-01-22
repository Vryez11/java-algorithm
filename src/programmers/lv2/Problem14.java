package src.programmers.lv2;

public class Problem14 {

    public int solution(int[] arr) {
        int gcd = arr[0];
        int mult = arr[0];

        if (arr.length == 1) {
            return arr[0];
        } else {
            for (int i = 1; i < arr.length; i++) {
                gcd = gcd(mult, arr[i]);
                mult = mult * arr[i] / gcd;
            }
        }

        return mult;
    }

    private int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        else {
            return gcd(b, a % b);
        }
    }
}
