package src.programmers.lv1;

public class Problem80 {

    private int max_minute;
    private int max_second;
    private int op_start_minute;
    private int op_start_second;
    private int op_end_minute;
    private int op_end_second;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] maxSplit = video_len.split(":");
        max_minute = Integer.parseInt(maxSplit[0]);
        max_second = Integer.parseInt(maxSplit[1]);

        String[] startSplit = op_start.split(":");
        op_start_minute = Integer.parseInt(startSplit[0]);
        op_start_second = Integer.parseInt(startSplit[1]);

        String[] endSplit = op_end.split(":");
        op_end_minute = Integer.parseInt(endSplit[0]);
        op_end_second = Integer.parseInt(endSplit[1]);

        TimeControll timeControll = new TimeControll(pos);

        for (String command : commands) {
            timeControll.remote(command);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(timeControll.minute).append(":").append(timeControll.second);
        String result = sb.toString();
        String[] resultSplit = result.split(":");

        return String.format("%02d:%02d", Integer.parseInt(resultSplit[0]), Integer.parseInt(resultSplit[1]));
    }

    private class TimeControll {
        private int minute;
        private int second;

        public TimeControll(String pos) {
            String[] timeSplit = pos.split(":");
            this.minute = Integer.parseInt(timeSplit[0]);
            this.second = Integer.parseInt(timeSplit[1]);
        }

        public void remote(String command) {
            if (command.equals("next")) {
                next();
            } else {
                prev();
            }
        }

        private void next() {
            opSkip();
            if (second >= 50) {
                minute++;
                second = second - 50;
            } else {
                second += 10;
            }
            opSkip();
            maxCheck();
        }

        private void prev() {
            opSkip();
            if (second >= 10) {
                second -= 10;
            } else {
                if (minute == 0) {
                    second = 0;
                } else {
                    minute--;
                    second = 50 + second;
                }
            }
            opSkip();
        }

        private void opSkip() {
            if (minute < op_end_minute || (minute == op_end_minute && second < op_end_second)) {
                if (minute > op_start_minute || (minute == op_start_minute && second >= op_start_second)) {
                    minute = op_end_minute;
                    second = op_end_second;
                }
            }
        }

        private void maxCheck() {
            if (minute > max_minute || (minute == max_minute && second > max_second)) {
                minute = max_minute;
                second = max_second;
            }
        }
    }
}
