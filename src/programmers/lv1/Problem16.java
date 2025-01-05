package src.programmers.lv1;

public class Problem16 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb = (i % 2 == 0) ? sb.append("수") : sb.append("박");
        }
        return sb.toString();
    }
}
