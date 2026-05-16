package src.programmers.lv3;

public class Problem32 {

    // 자물쇠와 열쇠
    public boolean solution(int[][] key, int[][] lock) {

        int m = key.length;
        int n = lock.length;

        int size = n + 2 * (m - 1);
        int start = m - 1;

        int[][] board = new int[size][size];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[start + i][start + j] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {

            for (int x = 0; x <= size - m; x++) {
                for (int y = 0; y <= size - m; y++) {

                    putKey(board, key, x, y);

                    if (canOpen(board, start, n)) {
                        return true;
                    }

                    removeKey(board, key, x, y);
                }
            }

            key = rotate(key);
        }

        return false;
    }

    private void putKey(int[][] board, int[][] key, int x, int y) {
        int m = key.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                board[x + i][y + j] += key[i][j];
            }
        }
    }

    private void removeKey(int[][] board, int[][] key, int x, int y) {
        int m = key.length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                board[x + i][y + j] -= key[i][j];
            }
        }
    }

    private boolean canOpen(int[][] board, int start, int n) {
        for (int i = start; i < start + n; i++) {
            for (int j = start; j < start + n; j++) {
                if (board[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] rotate(int[][] key) {
        int m = key.length;
        int[][] rotated = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][m - 1 - i] = key[i][j];
            }
        }

        return rotated;
    }
}