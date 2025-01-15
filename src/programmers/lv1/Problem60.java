package src.programmers.lv1;

public class Problem60 {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int solution(String[][] board, int h, int w) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (board[x][y].equals(board[h][w])) count++;
            }
        }

        return count;
    }
}
