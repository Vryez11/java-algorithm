package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            list.add(rotate(arr, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1));
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private int rotate(int[][] arr, int x1, int y1, int x2, int y2) {
        int minNum = Integer.MAX_VALUE;
        int temp = arr[x1][y1];

        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            minNum = Math.min(minNum, arr[i][y1]);
        }
        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            minNum = Math.min(minNum, arr[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            minNum = Math.min(minNum, arr[i][y2]);
        }
        for (int i = y2; i > y1 + 1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            minNum = Math.min(minNum, arr[x1][i]);
        }
        arr[x1][y1 + 1] = temp;
        minNum = Math.min(minNum, temp);

        return minNum;
    }
}