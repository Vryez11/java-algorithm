package src.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem62 {

    public String solution(String X, String Y) {
        char[] XArray = X.toCharArray();
        char[] YArray = Y.toCharArray();

        ArrayList<Character> list = new ArrayList<>();

        Arrays.sort(XArray);
        Arrays.sort(YArray);
        int indexX = 0; int indexY = 0;

        while (indexX < XArray.length && indexY < YArray.length) {
            if (XArray[indexX] > YArray[indexY]) {
                indexY++;
            } else if (XArray[indexX] < YArray[indexY]) {
                indexX++;
            } else {
                list.add(XArray[indexX]);
                indexX++;
                indexY++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character c : list) {
            sb.append(c);
        }
        String result = sb.reverse().toString();

        if (result.length() == 0) return "-1";
        else if (result.replaceAll("0", "").equals("")) return "0";
        else return result;
    }
}
