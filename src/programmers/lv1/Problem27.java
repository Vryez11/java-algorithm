package src.programmers.lv1;

import java.util.Arrays;

public class Problem27 {

    public int solution(int[] d, int budget) {
        int sum = 0;
        int res = 0;

        Arrays.sort(d);

        for (int amount : d) {
            if (budget >= amount + sum) {
                res++;
                sum += amount;
            } else
                break;
        }

        return res;
    }
}
