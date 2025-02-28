package src.programmers.lv2;

public class Problem67 {

    // 숫자 카드 나누기
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (isValid(gcdA, arrayB)) {
            return Math.max(gcdA, isValid(gcdB, arrayA) ? gcdB : 0);
        }

        if (isValid(gcdB, arrayA)) {
            return gcdB;
        }

        return 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private boolean isValid(int gcd, int[] array) {
        for (int num : array) {
            if (num % gcd == 0) {
                return false;
            }
        }
        return true;
    }
}
