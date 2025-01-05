package src.programmers.lv1;

import java.util.Arrays;

public class Problem18 {

    public String solution (String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder str = new StringBuilder(new String(charArray));
        return str.reverse().toString();
    }
}
