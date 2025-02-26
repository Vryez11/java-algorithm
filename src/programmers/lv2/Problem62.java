package src.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Problem62 {

    // 시소 짝꿍
    public long solution(int[] weights) {
        Map<Integer, Integer> weightMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int weight : weights) {
            weightMap.put(weight, weightMap.getOrDefault(weight, 0) + 1);
        }

        for (int weight : weights) {
            map.put(weight * 2, map.getOrDefault(weight * 2, 0) + 1);
            map.put(weight * 3, map.getOrDefault(weight * 3, 0) + 1);
            map.put(weight * 4, map.getOrDefault(weight * 4, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();

            if (value > 1) {
                count += (long) value * (value - 1) / 2;
            }
        }

        for (Map.Entry<Integer, Integer> entry : weightMap.entrySet()) {
            Integer value = entry.getValue();

            if (value > 1) {
                count -= (long) 2 * value * (value - 1) / 2;
            }
        }

        return count;
    }
}