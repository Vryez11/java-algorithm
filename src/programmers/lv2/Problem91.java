package src.programmers.lv2;

import java.util.*;

class Problem91 {
    public String[] solution(String[][] plans) {
        List<Plan> arr = new ArrayList<>();
        for (String[] p : plans) {
            arr.add(new Plan(p[0], p[1], p[2]));
        }

        arr.sort(Comparator.comparingInt(a -> a.startTime));

        List<String> result = new ArrayList<>();
        Deque<Plan> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            Plan now = arr.get(i);
            Plan next = arr.get(i + 1);

            int available = next.startTime - now.startTime;

            if (now.remainTime <= available) {
                result.add(now.name);
                int remain = available - now.remainTime;

                while (remain > 0 && !stack.isEmpty()) {
                    Plan stopped = stack.pop();

                    if (stopped.remainTime <= remain) {
                        remain -= stopped.remainTime;
                        result.add(stopped.name);
                    } else {
                        stopped.remainTime -= remain;
                        remain = 0;
                        stack.push(stopped);
                    }
                }
            } else {
                now.remainTime -= available;
                stack.push(now);
            }
        }

        result.add(arr.get(arr.size() - 1).name);

        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }

        return result.toArray(new String[0]);
    }

    class Plan {
        String name;
        int startTime;
        int remainTime;

        public Plan(String name, String startTime, String playTime) {
            this.name = name;
            this.remainTime = Integer.parseInt(playTime);

            String[] times = startTime.split(":");
            this.startTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
    }
}