package src.programmers.lv2;

import java.util.Stack;

public class Problem74 {

    // 괄호 변환
    public String solution(String p) {
        if (isCorrect(p)) return p;

        String answer = partitionAndMerge(p);

        return answer;
    }

    private boolean isCorrect(String p) {
        Stack<Character> stack = new Stack<>();

        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private String partitionAndMerge(String p) {
        if (p.isEmpty()) return p;

        char[] array = p.toCharArray();
        int openCount = 0;
        int closeCount = 0;

        for (char c : array) {
            if (c == '(') openCount++;
            else if (c == ')') closeCount++;

            if (openCount == closeCount) break;
        }
        String u = p.substring(0, openCount + closeCount);
        String v = p.substring(openCount + closeCount);

        if (isCorrect(u)) return u + partitionAndMerge(v);

        StringBuilder sb = new StringBuilder();
        StringBuilder sbU = new StringBuilder(u);
        sb.append('(');
        sb.append(partitionAndMerge(v));
        sb.append(')');
        sbU.deleteCharAt(0);
        sbU.deleteCharAt(sbU.length() - 1);
        for (int i = 0; i < sbU.length(); i++) {
            char c = sbU.charAt(i);
            if (c == '(') sb.append(')');
            else if (c == ')') sb.append('(');
        }

        return sb.toString();
    }
}
