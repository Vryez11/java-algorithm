package src.programmers.lv3;

public class Problem36Res {

    // 미로 탈출 명령어 - 완전한 풀이 (한 칸씩 그리디)
    // d < l < r < u 사전순으로, 매 칸마다 가능한 가장 작은 이동을 선택한다.
    private static final char[] DIR = {'d', 'l', 'r', 'u'};
    private static final int[] DX = {1, 0, 0, -1}; // d: 행 증가, u: 행 감소
    private static final int[] DY = {0, -1, 1, 0}; // l: 열 감소, r: 열 증가

    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        // 도달 가능성 판별: 맨해튼 거리가 k 이하이고, 남는 횟수가 짝수여야 왕복으로 채울 수 있다.
        int dist = Math.abs(r - x) + Math.abs(c - y);
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }

        // 1x1 격자는 한 칸도 움직일 수 없으므로 여분 이동(k > dist)을 채울 수 없다.
        if (k > dist && n == 1 && m == 1) {
            return "impossible";
        }

        StringBuilder sb = new StringBuilder();
        int curX = x;
        int curY = y;

        for (int step = 0; step < k; step++) {
            for (int d = 0; d < 4; d++) {
                int nx = curX + DX[d];
                int ny = curY + DY[d];

                // 격자 범위 검사
                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }

                // 이번 이동 후 남은 횟수로 도착점에 정확히 닿을 수 있는지 검사
                int remain = k - step - 1;
                int nextDist = Math.abs(nx - r) + Math.abs(ny - c);
                if (nextDist > remain || (remain - nextDist) % 2 != 0) {
                    continue;
                }

                // d, l, r, u 순서이므로 가장 먼저 통과한 방향이 사전순 최소
                sb.append(DIR[d]);
                curX = nx;
                curY = ny;
                break;
            }
        }

        return sb.toString();
    }
}
