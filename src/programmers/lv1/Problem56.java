package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Problem56 {

    public int solution(String s) {
        char[] sArray = s.toCharArray();
        int res = 0;
        String first = "";
        int firstCount = 0, sumCount;
        HashMap<String, Integer> myMap = new HashMap<>();

        for (int i = 0; i < sArray.length; i++) {
            sumCount = 0;
            myMap.put(sArray[i] + "", myMap.getOrDefault(sArray[i] + "", 0) + 1);
            if (myMap.size() == 1)
                first = String.valueOf(sArray[i]);

            for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
                if (entry.getKey().equals(first)) {
                    firstCount = entry.getValue();
                } else {
                    sumCount += entry.getValue();
                }
            }
            if (firstCount == sumCount) {
                res++;
                myMap.clear();
            }
        }
        if(!myMap.isEmpty()) res++;

        return res;
    }
}
