package src.programmers.lv2;

public class Problem54 {

    int zeroCount;
    int oneCount;

    // 쿼드압축 후 개수 세기
    public int[] solution(int[][] arr) {
        zeroCount = 0;
        oneCount = 0;
        int arrRange = arr.length;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) zeroCount++;
                else oneCount++;
            }
        }

        while (arrRange > 1) {
            for (int i = 0; i < arr.length; i += arrRange) {
                for (int j = 0; j < arr[i].length; j += arrRange) {
                    compression(arr, i, j, arrRange);
                }
            }

            arrRange /= 2;
        }

        return new int[]{zeroCount, oneCount};
    }

    private void compression(int[][] arr, int i, int j, int arrRange) {
        int initNumber = arr[i][j];
        if (initNumber == 3 || initNumber == 4) {
            return;
        }

        for (int y = i; y < i + arrRange; y++) {
            for (int x = j; x < j + arrRange; x++) {
                if (initNumber != arr[y][x]) {
                    return;
                }
                if (y == i + arrRange - 1 && x == j + arrRange - 1) {
                    int changeNumber;
                    if (initNumber == 0) changeNumber = 3;
                    else changeNumber = 4;

                    for (int p = i; p < i + arrRange; p++) {
                        for (int q = j; q < j + arrRange; q++) {
                            arr[p][q] = changeNumber;
                        }
                    }

                    if (initNumber == 0) zeroCount = zeroCount - (arrRange * arrRange) + 1;
                    else oneCount = oneCount - (arrRange * arrRange) + 1;
                }
            }
        }
    }
}
