package src.programmers.lv1;

public class Problem79 {

    public int solution(int[] mats, String[][] park) {
        int maxMat = 0;

        for (int mat : mats) {
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length; j++) {
                    if (park[i][j].equals("-1")) {
                        if (isSquare(mat, park, i, j)) {
                            maxMat = Math.max(maxMat, mat);
                        }
                    }
                }
            }
        }

        if (maxMat == 0) return -1;
        else return maxMat;
    }

    private boolean isSquare(int mat, String[][] park, int i, int j) {
        for (int k = 0; k < mat; k++) {
            for (int q = 0; q < mat; q++) {
                if ((i + k) >= park.length || (j + q) >= park[0].length) return false;
                if (!park[i + k][j + q].equals("-1")) return false;
            }
        }
        return true;
    }
}
