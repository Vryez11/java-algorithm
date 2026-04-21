package src.programmers.lv3;

import java.util.*;

public class Problem14 {

    // 보석 쇼핑
    public int[] solution(String[] gems) {

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {

            map.putIfAbsent(gems[i], new ArrayList<>());
            map.get(gems[i]).add(i);
        }

        int[] res = new int[2];
        int dist = Integer.MAX_VALUE;
        Set<String> keySet = map.keySet();
        int keyCount = keySet.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String key : keySet) {
            min = Math.min(min, map.get(key).get(0));
            max = Math.max(max, map.get(key).get(0));
        }
        while (true) {

            if (dist > max - min) {
                res[0] = min + 1;
                res[1] = max + 1;
                dist = max - min;

                if (dist + 1 == keyCount) {
                    return res;
                }
            }

            map.get(gems[min]).remove(0);
            if (map.get(gems[min]).isEmpty()) {
                break;
            }

            max = Math.max(map.get(gems[min]).get(0), max);
            min = min + 1;
        }

        return res;
    }
}
