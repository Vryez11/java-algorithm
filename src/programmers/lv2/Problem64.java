package src.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem64 {

    // 호텔 대실
    public int solution(String[][] book_time) {
        int result = 0;

        List<Integer> rooms = new ArrayList<>();
        List<Integer> removeObj = new ArrayList<>();
        int[][] minArr = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            String[] splitTime = book_time[i][0].split(":");
            minArr[i][0] = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            splitTime = book_time[i][1].split(":");
            minArr[i][1] = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
        }
        Arrays.sort(minArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] time : minArr) {
            int start = time[0];
            int end = time[1];

            if (rooms.isEmpty()) {
                rooms.add(end + 10);
            } else {
                for (Integer room : rooms) {
                    if (room <= start) {
                        removeObj.add(room);
                    }
                }
                for (Integer obj : removeObj) {
                    rooms.remove(obj);
                }
                rooms.add(end + 10);
            }

            result = Math.max(result, rooms.size());
        }

        return result;
    }
}
