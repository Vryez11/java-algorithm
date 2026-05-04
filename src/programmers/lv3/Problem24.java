package src.programmers.lv3;

import java.util.HashMap;
import java.util.Map;

public class Problem24 {

    // 다단계 칫솔 판매
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String name : enroll) {
            map.put(name, index++);
        }

        int[] parents = new int[enroll.length];
        for (int i = 0; i < referral.length; i++) {

            if (referral[i].equals("-")) {
                parents[i] = -1;
                continue;
            }

            int idx = map.get(referral[i]);
            parents[i] = idx;
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < seller.length; i++) {
            int idx = map.get(seller[i]);
            int pay = amount[i] * 100;

            do {
                result[idx] += pay - (pay / 10);
                pay /= 10;
                idx = parents[idx];
            } while (idx >= 0);
        }

        return result;
    }
}
