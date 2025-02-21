package src.baekjoon.sw;

import java.util.*;

public class Problem3 {

    // 1, 2, 3 더하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] dp = new int[11]; // n은 10 이하이므로 11까지 생성

        // DP 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 점화식 적용하여 dp 배열 채우기
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 테스트 케이스 처리
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }

        sc.close();
    }
}
