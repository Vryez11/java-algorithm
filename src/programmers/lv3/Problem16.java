package src.programmers.lv3;

import java.util.*;

public class Problem16 {

    // 섬 연결하기
    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int count = 0;

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int w = cost[2];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += w;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    private int find(int[] parent, int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    private void union(int[] parent, int x, int y) {

        int px = find(parent, x);
        int py = find(parent, y);

        if (px != py) {
            parent[py] = px;
        }
    }
}
