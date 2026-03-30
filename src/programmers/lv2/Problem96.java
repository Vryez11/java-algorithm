package src.programmers.lv2;

public class Problem96 {

    // 혼자서 하는 틱택토
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;

        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'O') oCount++;
                else if (map[i][j] == 'X') xCount++;
            }
        }

        if (oCount < xCount || oCount > xCount + 1) return 0;

        boolean oWin = isWin(map, 'O');
        boolean xWin = isWin(map, 'X');

        if (oWin && xWin) return 0;
        if (oWin && oCount != xCount + 1) return 0;
        if (xWin && oCount != xCount) return 0;

        return 1;
    }

    private boolean isWin(char[][] map, char target) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == target && map[i][1] == target && map[i][2] == target) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (map[0][j] == target && map[1][j] == target && map[2][j] == target) {
                return true;
            }
        }

        if (map[0][0] == target && map[1][1] == target && map[2][2] == target) {
            return true;
        }

        if (map[0][2] == target && map[1][1] == target && map[2][0] == target) {
            return true;
        }

        return false;
    }
}