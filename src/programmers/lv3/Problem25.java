package src.programmers.lv3;

public class Problem25 {

    // 가장 긴 팰린드롬
    public int solution(String s) {

        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, expand(s, i, i));
            answer = Math.max(answer, expand(s, i, i + 1));
        }

        return answer;
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
