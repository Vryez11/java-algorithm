package src.programmers.lv3;

public class Problem10 {

    // 기지국 설치
    public int solution(int n, int[] stations, int w) {

        int answer = 0;
        int cover = 2 * w + 1;

        int start = 1;
        for (int station : stations) {
            int left = station - w;

            if (start < left) {
                int len = left - start;
                answer += (len + cover - 1) / cover;
            }

            start = station + w + 1;
        }

        if (start <= n) {
            int len = n - start + 1;
            answer += (len + cover - 1) / cover;
        }

        return answer;
    }
}
