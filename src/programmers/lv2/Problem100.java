package src.programmers.lv2;

public class Problem100 {

    // 조이스틱
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);

            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i * 2 + (name.length() - next));
            move = Math.min(move, (name.length() - next) * 2 + i);
        }

        return answer + move;
    }
}