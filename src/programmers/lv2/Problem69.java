package src.programmers.lv2;

import java.util.*;

public class Problem69 {

    static Map<String, Integer> combinationMap;

    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        for (int c : course) {
            combinationMap = new HashMap<>();
            int maxCount = 0;

            for (String order : orders) {
                char[] orderArray = order.toCharArray();
                Arrays.sort(orderArray);
                getCombinations(orderArray, new StringBuilder(), 0, c);
            }

            for (int count : combinationMap.values()) {
                maxCount = Math.max(maxCount, count);
            }

            for (String key : combinationMap.keySet()) {
                if (combinationMap.get(key) == maxCount && maxCount >= 2) {
                    answerList.add(key);
                }
            }
        }

        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    private void getCombinations(char[] order, StringBuilder sb, int index, int length) {
        if (sb.length() == length) {
            String key = sb.toString();
            combinationMap.put(key, combinationMap.getOrDefault(key, 0) + 1);
            return;
        }

        for (int i = index; i < order.length; i++) {
            sb.append(order[i]);
            getCombinations(order, sb, i + 1, length);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
