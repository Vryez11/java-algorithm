package src.programmers.lv2;

public class Problem8 {

    //피보나치 수
    public int solution(int n) {

        int[] S = new int[n + 1];
        S[0] = 0;
        S[1] = 1;
        for (int i = 2; i <= n; i++) {
            S[i] = S[i - 2] % 1234567 + S[i - 1] % 1234567;
        }
        return S[n] % 1234567;
    }
}
