package src.programmers.lv2;

public class Problem6 {

    //숫자의 표현
    public int solution(int n) {
        long[] S = new long[n + 1];
        int start = 1; int end = 1;
        int count = 0;

        for (int i = 1; i < n; i++) {
            S[i] = S[i - 1] + i;
        }

        while (start <= n / 2) {
            if (end > n) break;

            if (S[end] - S[start - 1] < n) end++;
            else if (S[end] - S[start - 1] > n) start++;
            else {
                count++;
                start++;
                end = start + 1;
            }
        }

        return ++count;
    }
}
