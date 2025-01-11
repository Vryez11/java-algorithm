package src.programmers.lv1;

public class Problem50 {

    public int solution(int n, int m, int[] section) {
        boolean[] area = new boolean[n + 1];
        int cnt = 0;

        for (int i = 0; i < section.length; i++) {
            if (!area[section[i]]) {
                cnt++;
                for (int j = 0; j < m; j++) {
                    if (section[i] + j > n) break;
                    area[section[i] + j] = true;
                }
            }
        }

        return cnt;
    }
}
