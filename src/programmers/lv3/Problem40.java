package src.programmers.lv3;

public class Problem40 {

    int MOD = 20170805;

    // 보행자 천국
    public int solution(int m, int n, int[][] cityMap) {

        int[][] down = new int[m][n];
        int[][] right = new int[m][n];

        down[0][0] = 1;
        right[0][0] = 1;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {

                if (cityMap[y][x] == 1) continue;

                int total;

                if (cityMap[y][x] == 2) {
                    if (y + 1 < m) {
                        down[y + 1][x] = (down[y + 1][x] + down[y][x]) % MOD;
                    }

                    if (x + 1 < n) {
                        right[y][x + 1] = (right[y][x + 1] + right[y][x]) % MOD;
                    }
                } else {
                    total = (down[y][x] + right[y][x]) % MOD;

                    if (y == 0 && x == 0) {
                        total = 1;
                    }

                    if (y + 1 < m) {
                        down[y + 1][x] = (down[y + 1][x] + total) % MOD;
                    }

                    if (x + 1 < n) {
                        right[y][x + 1] = (right[y][x + 1] + total) % MOD;
                    }
                }
            }
        }

        return (down[m - 1][n - 1] + right[m - 1][n - 1]) % MOD;
    }
}