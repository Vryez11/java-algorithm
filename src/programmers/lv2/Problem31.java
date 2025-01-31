package src.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class Problem31 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // 문자열을 2글자씩 끊어 다중집합 생성
        addToMap(str1, map1);
        addToMap(str2, map2);

        // 교집합과 합집합 계산
        int intersection = 0, union = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
            }
            union += map1.get(key);
        }
        for (String key : map2.keySet()) {
            union += map2.get(key);
        }
        union -= intersection;

        // 자카드 유사도 계산
        return (union == 0) ? 65536 : (int) ((double) intersection / union * 65536);
    }

    private void addToMap(String str, Map<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(i + 1))) {
                String pair = str.substring(i, i + 2);
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }
    }
}
