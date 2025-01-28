package src.programmers.lv2;

import java.util.*;

public class Problem25 {

    // [1차] 캐시
    public int solution(int cacheSize, String[] cities) {
        List<String> list = new LinkedList<>();
        int runTime = 0;
        int currentSize = 0;

        if (cacheSize == 0) {
            runTime += 5 * cities.length;
            return runTime;
        }
        for (String city : cities) {
            city = city.toLowerCase();
            if (list.isEmpty()) {
                list.add(city);
                currentSize++;
                runTime += 5;
            } else if (list.contains(city)) {
                runTime += 1;
                list.remove(city);
                currentSize--;
                list.add(currentSize, city);
                currentSize++;
            } else if (currentSize >= cacheSize) {
                list.remove(0);
                list.add(city);
                runTime += 5;
            } else {
                list.add(city);
                currentSize++;
                runTime += 5;
            }
        }

        return runTime;
    }
}
