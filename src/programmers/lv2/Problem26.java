package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class Problem26 {

    // 기능개발
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> res = new ArrayList<>();
        int[] finished = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            int dDay = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                dDay++;
            }
            finished[i] = dDay;
        }

        int day = finished[0];
        int dayCount = 1;
        for (int i = 1; i < finished.length; i++) {
            if (day < finished[i]) {
                res.add(dayCount);
                day = finished[i];
                dayCount = 1;
            } else {
                dayCount++;
            }
        }
        res.add(dayCount);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
