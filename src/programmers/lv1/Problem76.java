package src.programmers.lv1;

import java.util.Stack;

public class Problem76 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int count = 0;

        Stack<Integer> tempBox = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move-1] != 0) {
                    if (count == 0) {
                        count++;
                        tempBox.push(board[i][move-1]);
                    } else {
                        if (board[i][move-1] == tempBox.peek()) {
                            tempBox.pop();
                            answer += 2;
                            count--;
                        } else {
                            count++;
                            tempBox.push(board[i][move-1]);
                        }
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
