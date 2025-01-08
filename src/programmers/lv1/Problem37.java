package src.programmers.lv1;

import java.util.Arrays;

public class Problem37 {

    public int[] solution(int[] array, int [][] commands) {
        int count = 0;
        int maxCount = commands.length;
        int[] res = new int[maxCount];

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] tempArr = new int[j - i + 1];
            for (int w = i; w <= j; w++) {
                tempArr[w - i] = array[w - 1];
            }
            Arrays.sort(tempArr);

            res[count++] = tempArr[k - 1];
        }
        return res;
    }
}
