package src.programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class Problem38 {

    // 기둥과 보 설치
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][][] structure = new boolean[n + 1][n + 1][2];

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            if (b == 1) {
                structure[x][y][a] = true;

                if (!isValidAll(n, structure)) {
                    structure[x][y][a] = false;
                }
            } else {
                structure[x][y][a] = false;

                if (!isValidAll(n, structure)) {
                    structure[x][y][a] = true;
                }
            }
        }

        List<int[]> answer = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (structure[x][y][0]) {
                    answer.add(new int[]{x, y, 0});
                }

                if (structure[x][y][1]) {
                    answer.add(new int[]{x, y, 1});
                }
            }
        }

        return answer.toArray(new int[answer.size()][]);
    }

    private boolean isValidAll(int n, boolean[][][] structure) {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (structure[x][y][0] && !canBuildColumn(x, y, structure)) {
                    return false;
                }

                if (structure[x][y][1] && !canBuildBeam(x, y, structure)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean canBuildColumn(int x, int y, boolean[][][] structure) {
        if (y == 0) {
            return true;
        }

        if (structure[x][y - 1][0]) {
            return true;
        }

        if (x > 0 && structure[x - 1][y][1]) {
            return true;
        }

        if (structure[x][y][1]) {
            return true;
        }

        return false;
    }

    private boolean canBuildBeam(int x, int y, boolean[][][] structure) {
        if (y > 0 && structure[x][y - 1][0]) {
            return true;
        }

        if (y > 0 && structure[x + 1][y - 1][0]) {
            return true;
        }

        if (x > 0 && structure[x - 1][y][1] && structure[x + 1][y][1]) {
            return true;
        }

        return false;
    }
}
