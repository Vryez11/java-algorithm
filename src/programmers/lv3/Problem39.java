package src.programmers.lv3;

public class Problem39 {

    // 광고 삽입
    public String solution(String play_time, String adv_time, String[] logs) {

        int videoSecond = changeSecond(play_time, 0);
        int advSecond = changeSecond(adv_time, 0);

        long[] timeline = new long[videoSecond + 2];

        for (String log : logs) {
            int start = changeSecond(log, 0);
            int end = changeSecond(log, 1);

            timeline[start] += 1;
            timeline[end] -= 1;
        }

        for (int i = 1; i <= videoSecond; i++) {
            timeline[i] += timeline[i - 1];
        }

        for (int i = 1; i <= videoSecond; i++) {
            timeline[i] += timeline[i - 1];
        }

        long maxWatchTime = timeline[advSecond - 1];
        int answer = 0;

        for (int start = 1; start + advSecond <= videoSecond; start++) {
            int end = start + advSecond - 1;

            long watchTime = timeline[end] - timeline[start - 1];

            if (watchTime > maxWatchTime) {
                maxWatchTime = watchTime;
                answer = start;
            }
        }

        return changeTime(answer);
    }

    private int changeSecond(String time, int idx) {
        String target = time;

        if (time.contains("-")) {
            target = time.split("-")[idx];
        }

        String[] times = target.split(":");

        return Integer.parseInt(times[0]) * 3600
                + Integer.parseInt(times[1]) * 60
                + Integer.parseInt(times[2]);
    }

    private String changeTime(int second) {
        int hour = second / 3600;
        second %= 3600;

        int minute = second / 60;
        int sec = second % 60;

        return String.format("%02d:%02d:%02d", hour, minute, sec);
    }
}