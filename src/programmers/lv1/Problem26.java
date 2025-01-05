package src.programmers.lv1;

public class Problem26 {

    public String solution(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (String word : words) {
            word = word.toLowerCase();
            char[] charArray = word.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0) charArray[i] = Character.toUpperCase(charArray[i]);
            }

            res.append(String.valueOf(charArray)).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
