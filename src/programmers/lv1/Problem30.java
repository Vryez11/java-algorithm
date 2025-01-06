package src.programmers.lv1;

public class Problem30 {

    public int solution(int[][] sizes) {
        int maxLen = 0;
        int secondLen = 0;

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
                maxLen = Math.max(maxLen, sizes[i][j]);
            }
        }

        for (int i = 0; i < sizes.length; i++) {
            int secondTemp = Math.min(sizes[i][0], sizes[i][1]);
            secondLen = Math.max(secondLen, secondTemp);
        }
        return maxLen * secondLen;
    }
}
