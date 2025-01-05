package src.programmers.lv1;

public class Problem13 {

    public String solution(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}
