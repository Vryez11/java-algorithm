package src.programmers.lv1;

public class Problem8 {

    public String solution(String[] seoul) {
        int cnt = 0;

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                cnt = i;
            }
        }

        return "김서방은 " + cnt + "에 있다";
    }
}
