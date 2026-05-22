package src.programmers.lv3;

import java.util.Stack;

public class Problem35 {

    // 표 편집
    public String solution(int n, int k, String[] cmd) {

        int[] prev = new int[n];
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        next[n - 1] = -1;

        Stack<int[]> deleted = new Stack<>();

        int current = k;

        for (String command : cmd) {
            char type = command.charAt(0);

            if (type == 'U') {
                int count = Integer.parseInt(command.substring(2));

                while (count-- > 0) {
                    current = prev[current];
                }
            }

            else if (type == 'D') {
                int count = Integer.parseInt(command.substring(2));

                while (count-- > 0) {
                    current = next[current];
                }
            }

            else if (type == 'C') {
                deleted.push(new int[]{current, prev[current], next[current]});

                if (prev[current] != -1) {
                    next[prev[current]] = next[current];
                }

                if (next[current] != -1) {
                    prev[next[current]] = prev[current];
                }

                if (next[current] != -1) {
                    current = next[current];
                } else {
                    current = prev[current];
                }
            }

            else if (type == 'Z') {
                int[] row = deleted.pop();

                int restore = row[0];
                int before = row[1];
                int after = row[2];

                if (before != -1) {
                    next[before] = restore;
                }

                if (after != -1) {
                    prev[after] = restore;
                }
            }
        }

        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            answer[i] = 'O';
        }

        while (!deleted.isEmpty()) {
            int[] row = deleted.pop();
            answer[row[0]] = 'X';
        }

        return new String(answer);
    }
}