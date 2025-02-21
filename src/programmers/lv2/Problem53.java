package src.programmers.lv2;

import java.util.*;

public class Problem53 {

    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNums, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if(strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }
}
