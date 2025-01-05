package src.programmers.lv1;

public class Problem15 {

    public String solution(String s) {
        int length = s.length();
        if (length % 2 == 0) {
            return s.charAt(length / 2 - 1) + String.valueOf(s.charAt(length / 2));
        } else {
            return String.valueOf(s.charAt(length/2));
        }
    }
}
