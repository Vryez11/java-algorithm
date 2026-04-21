package src.programmers.lv3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem14Ref {

    // 보석 쇼핑
    public int[] solution(String[] gems) {
        Set<String> types = new HashSet<>();
        for (String gem : gems) {
            types.add(gem);
        }

        int totalKinds = types.size();

        Map<String, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;

        int bestStart = 0;
        int bestEnd = gems.length - 1;
        countMap.put(gems[0], 1);

        while (left <= right && right < gems.length) {
            if (countMap.size() == totalKinds) {
                if ((right - left) < (bestEnd - bestStart)) {
                    bestStart = left;
                    bestEnd = right;
                }

                int count = countMap.get(gems[left]);
                if (count == 1) {
                    countMap.remove(gems[left]);
                } else {
                    countMap.put(gems[left], count - 1);
                }
                left++;
            } else {
                right++;
                if (right == gems.length) {
                    break;
                }
                countMap.put(gems[right], countMap.getOrDefault(gems[right], 0) + 1);
            }
        }

        return new int[]{bestStart + 1, bestEnd + 1};
    }
}