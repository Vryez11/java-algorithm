package src.programmers.lv2;

import java.util.*;

public class Problem82 {

    // 하노이의 탑
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 3, 2, moves);
        return moves.toArray(new int[moves.size()][]);
    }

    private void hanoi(int n, int from, int to, int aux, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }
        hanoi(n - 1, from, aux, to, moves);
        moves.add(new int[]{from, to});
        hanoi(n - 1, aux, to, from, moves);
    }
}
