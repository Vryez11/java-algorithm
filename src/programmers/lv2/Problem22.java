package src.programmers.lv2;

public class Problem22 {

    // 행렬의 곱셈
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] result = new int[arr1.length][arr2[0].length];
        int multSum = 0;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    multSum += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = multSum;
                multSum = 0;
            }
        }

        return result;
    }
}
