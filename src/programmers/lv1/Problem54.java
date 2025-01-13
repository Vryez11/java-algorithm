package src.programmers.lv1;

import java.util.Arrays;

public class Problem54 {

    public int solution(String dartResult) {
        char[] resultArray = dartResult.toCharArray();

        String[] options = new String[3];
        int optionIndex = 0;
        int[] scores = new int[3];
        int[] result = new int[3];
        int scoreIndex = 0;

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] >= '0' && resultArray[i] <= '9') {
                String scoreTemp = String.valueOf(resultArray[i]);
                if (resultArray[i + 1] == '0') {
                    scoreTemp += String.valueOf(resultArray[i + 1]);
                    i++;
                }
                scores[scoreIndex] = Integer.parseInt(scoreTemp);
                scoreIndex++;
            } else {
                String optionTemp = String.valueOf(resultArray[i]);
                if (i != resultArray.length - 1 && (resultArray[i + 1] == '#' || resultArray[i + 1] == '*')) {
                    optionTemp += String.valueOf(resultArray[i + 1]);
                    i++;
                }
                options[optionIndex] = optionTemp;
                optionIndex++;
            }
        }

        for (int i = scores.length - 1; i >= 0; i--) {
            int temp;
            if (options[i].contains("T")) {
                temp = (int) Math.pow(scores[i], 3);
            } else if (options[i].contains("D")) {
                temp = (int) Math.pow(scores[i], 2);
            } else {
                temp = (int) Math.pow(scores[i], 1);
            }
            result[i] = temp;
        }

        for (int i = 0; i < 3; i++) {
            if (options[i].contains("#")) result[i] = (-1) * result[i];
            if (options[i].contains("*")) {
                if (i == 0) result[i] = 2 * result[i];
                else {
                    result[i - 1] = 2 * result[i - 1];
                    result[i] = 2 * result[i];
                }
            }
        }
        return Arrays.stream(result).sum();
    }
}
