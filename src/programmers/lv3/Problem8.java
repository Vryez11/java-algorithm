package src.programmers.lv3;

import java.util.Arrays;

public class Problem8 {

    // 단속카메라
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        int round = routes[0][1];
        int answer = 0;
        for (int i = 1; i < routes.length; i++) {

            if (round < routes[i][0]) {
                answer++;
                round = routes[i][1];
                continue;
            }

            if (round > routes[i][1]) {
                round = routes[i][1];
            }
        }

        return answer + 1;
    }
}
