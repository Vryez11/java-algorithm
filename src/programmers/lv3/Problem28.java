package src.programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem28 {

    // 셔틀버스
    public String solution(int n, int t, int m, String[] timetable) {

        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        int[] minutes = new int[timetable.length];
        for (int i = 0; i < minutes.length; i++) {
            String[] times = timetable[i].split(":");
            minutes[i] = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
        Arrays.sort(minutes);

        int[] transTime = new int[n];
        for (int i = 0; i < transTime.length; i++) {
            transTime[i] = 9 * 60 + t * i;
        }

        int idx = 0;
        for (int i = 0; i < minutes.length; i++) {

            while (idx < n && (lists[idx].size() == m || minutes[i] > transTime[idx])) {
                idx++;
            }

            if (idx == n) {
                break;
            }

            lists[idx].add(minutes[i]);
        }

        int answer = 0;

        if (lists[n - 1].size() < m) {
            answer = transTime[n - 1];
        } else {
            answer = lists[n - 1].get(m - 1) - 1;
        }

        int hour = answer / 60;
        String hours = hour / 10 == 0 ? "0" + hour : hour + "";
        int min = answer % 60;
        String mins = min / 10 == 0 ? "0" + min : min + "";

        return hours + ":" + mins;
    }
}
