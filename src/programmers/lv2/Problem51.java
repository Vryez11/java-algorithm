package src.programmers.lv2;

class Problem51 {

    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int totalRemoved = 0;
        boolean found;

        do {
            boolean[][] marked = new boolean[m][n];
            found = false;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '.' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
                        marked[i][j] = marked[i][j + 1] = marked[i + 1][j] = marked[i + 1][j + 1] = true;
                        found = true;
                    }
                }
            }

            if (found) {
                totalRemoved += removeBlocks(map, marked, m, n);
                dropBlocks(map, m, n);
            }
        } while (found);

        return totalRemoved;
    }

    private int removeBlocks(char[][] map, boolean[][] marked, int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j]) {
                    map[i][j] = '.';
                    count++;
                }
            }
        }
        return count;
    }

    private void dropBlocks(char[][] map, int m, int n) {
        for (int j = 0; j < n; j++) {
            int emptyRow = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] != '.') {
                    char temp = map[i][j];
                    map[i][j] = '.';
                    map[emptyRow][j] = temp;
                    emptyRow--;
                }
            }
        }
    }
}
