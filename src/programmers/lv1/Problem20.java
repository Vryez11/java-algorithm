package src.programmers.lv1;

public class Problem20 {

    public boolean solution(String s) {
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c < '0' || c > '9') return false;
        }

        return s.length() == 4 || s.length() == 6;
    }
}
