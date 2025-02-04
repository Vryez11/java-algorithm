package src.programmers.lv2;

public class Problem39 {

    // [3차] n진수 게임
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;
        int myIndex = p;

        while (answer.length() < t) {
            sb.append(Integer.toString(num, n));
            while (myIndex <= sb.length() && answer.length() < t) {
                answer.append(Character.toUpperCase(sb.charAt(myIndex - 1)));
                myIndex += m;
            }
            num++;
        }

        return answer.toString();
    }
}
