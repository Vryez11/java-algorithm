package src.programmers.lv1;

public class Problem31 {

    public String solution(String s, int n) {
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = (char) (((charArray[i] - 65 + n) % 26) + 65);
            } else if (Character.isLowerCase(charArray[i])) {
                charArray[i] = (char) (((charArray[i] - 97 + n) % 26) + 97);
            }
        }

        return String.valueOf(charArray);
    }
}
