package src.programmers.lv3;

public class Problem9 {

    // 최고의 집합
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];
        int base = s / n;
        int remain = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = base;
        }

        for (int i = n - 1; i >= n - remain; i--) {
            answer[i]++;
        }

        return answer;
    }
}