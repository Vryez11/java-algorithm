package src.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Problem33 {

    // 롤케이크 자르기
    public int solution(int[] topping) {

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < topping.length; i++) {
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }
        for (int i = 0; i < topping.length; i++) {
            if (rightMap.get(topping[i]) - 1 == 0) {
                rightMap.remove(topping[i]);
            } else {
                rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            }

            leftMap.put(topping[i], leftMap.getOrDefault(topping[i], 0) + 1);

            if (leftMap.keySet().size() == rightMap.keySet().size()) {
                result++;
            }
        }

        return result;
    }
}
