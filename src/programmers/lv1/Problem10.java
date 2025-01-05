package src.programmers.lv1;

public class Problem10 {

    public int solution(int[] absolutes, boolean[]sings) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer = sings[i] ? answer + absolutes[i] : answer - absolutes[i];
        }

        return answer;
    }
}
