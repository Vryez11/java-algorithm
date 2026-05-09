package src.programmers.lv3;

import java.util.Arrays;

class Problem28Ref {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] crewTimes = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            String[] time = timetable[i].split(":");
            crewTimes[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }

        Arrays.sort(crewTimes);

        int crewIdx = 0;
        int answer = 0;

        for (int bus = 0; bus < n; bus++) {
            int busTime = 9 * 60 + bus * t;
            int count = 0;

            while (
                    crewIdx < crewTimes.length &&
                            crewTimes[crewIdx] <= busTime &&
                            count < m
            ) {
                crewIdx++;
                count++;
            }

            // 마지막 셔틀일 때 정답 계산
            if (bus == n - 1) {
                if (count < m) {
                    answer = busTime;
                } else {
                    answer = crewTimes[crewIdx - 1] - 1;
                }
            }
        }

        return String.format("%02d:%02d", answer / 60, answer % 60);
    }
}