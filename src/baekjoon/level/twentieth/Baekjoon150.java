package src.baekjoon.level.twentieth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon150 {

    static int [][] board = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static ArrayList<int[]> empties = new ArrayList<>();
    static boolean solved = false;

    static int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    static void dfs(int idx) {
        if (solved) return;
        if (idx == empties.size()) {
            solved = true;
            return;
        }

        int r = empties.get(idx)[0];
        int c = empties.get(idx)[1];
        int b = boxIndex(r, c);

        for (int num = 1; num <= 9; num++) {
            if (!row[r][num] && !col[c][num] && !box[b][num]) {
                board[r][c] = num;
                row[r][num] = col[c][num] = box[b][num] = true;

                dfs(idx + 1);

                if (solved) return;

                board[r][c] = 0;
                row[r][num] = col[c][num] = box[b][num] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int r = 0; r < 9; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 9; c++) {
                int val = Integer.parseInt(st.nextToken());
                board[r][c] = val;

                if (val ==0) {
                    empties.add(new int[]{r,c});
                } else {
                    row[r][val] = true;
                    col[c][val] = true;
                    box[boxIndex(r,c)][val] = true;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(board[r][c]);
                if (c < 8) sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
