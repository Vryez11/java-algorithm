package src.programmers.lv2;

import java.util.*;

public class Problem97 {

    // 요격 시스템
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int lastX = 0;
        int count = 0;

        for (int[] target : targets) {

            if (lastX == 0) {
                list.add(target);
                lastX = target[1];
                continue;
            }

            if (lastX <= target[0]) {
                count++;
                list = new ArrayList<>();
                list.add(target);
                lastX = target[1];
                continue;
            }

            if (lastX > target[1]) {
                lastX = target[1];
            }
            list.add(target);
        }

        if (!list.isEmpty()) count++;

        return count;
    }
}