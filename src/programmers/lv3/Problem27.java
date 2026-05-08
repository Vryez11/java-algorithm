package src.programmers.lv3;

public class Problem27 {

    // 풍선 터트리기
    public int solution(int[] a) {

        int n = a.length;

        boolean[] possible = new boolean[n];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                possible[i] = true;
                min = a[i];
            }
        }

        min = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < min) {
                possible[i] = true;
                min = a[i];
            }
        }

        int answer = 0;

        for (boolean canSurvive : possible) {
            if (canSurvive) {
                answer++;
            }
        }

        return answer;
    }
}
