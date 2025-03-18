package src.programmers.lv2;

public class Problem81 {

    // 가장 큰 정사각형 찾기
    public int solution(int [][]board) {

        int max = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && i > 0 && j > 0) {
                    board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + board[i][j];
                }

                max = Math.max(max, board[i][j]);
            }
        }

        return max * max;
    }
}
