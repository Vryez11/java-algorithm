package src.programmers.lv1;

public class Problem25 {

    public int solution(String t, String p) {

        int len = p.length();
        int count = t.length() - len;
        int result = 0;

        for (int i = 0; i < count + 1; i++){
            if (Long.parseLong(t.substring(i, i + len)) <= Long.parseLong(p))
                result++;
        }

        return result;
    }
}
