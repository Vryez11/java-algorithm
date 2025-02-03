package src.programmers.lv2;

public class Problem37 {

    // k진수에서 소수 개수 구하기
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n >= 1) {
            sb.append(n % k);
            n /= k;
        }
        sb.reverse();

        String[] split = sb.toString().split("0+");

        int count = 0;
        for (String s : split) {
            if(isPrime(Long.parseLong(s)))
                count++;
        }

        return count;
    }

    private boolean isPrime(long n) {
        if (n == 1L) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}