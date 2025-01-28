package src.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Problem23 {

    // 의상
    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<>();

        for (String[] clothe : clothes) {
            closet.put(clothe[1], closet.getOrDefault(clothe[1], 0) + 1);
        }

        int result = 1;
        for (Integer value : closet.values()) {
            result *= (value + 1);
        }

        return result - 1;
    }
}
