package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class Problem21 {

    // n^2 배열 자르기
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> res = new ArrayList<>();

        for (long i = left; i <= right; i++) {
            int yIndex = (int) (i / n) + 1;
            int xIndex = (int) (i % n) + 1;
            res.add(Math.max(yIndex, xIndex));
        }

        return res;
    }
}
