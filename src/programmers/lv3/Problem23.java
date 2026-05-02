package src.programmers.lv3;

import java.util.PriorityQueue;

public class Problem23 {

    // 디스크 컨트롤러
    public int solution(int[][] jobs) {

        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.time == b.time) {
                if (a.request == b.request) {
                    return a.index - b.index;
                }
                return a.request - b.request;
            }
            return a.time - b.time;
        });

        boolean[] used = new boolean[jobs.length];
        int sum = 0;
        int time = 0;
        int n = jobs.length;
        int jobCount = 0;
        int minRequest = Integer.MAX_VALUE;

        for (int i = 0; i < jobs.length; i++) {
            minRequest = Math.min(minRequest, jobs[i][0]);
        }

        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i][0] == minRequest) {
                pq.offer(new Job(i, jobs[i][0], jobs[i][1]));
                used[i] = true;
                jobCount++;
            }
        }

        while (!(pq.isEmpty() && jobCount == n)) {

            for (int i = 0; i < jobs.length; i++) {
                if (used[i]) continue;

                if (time >= jobs[i][0]) {
                    pq.add(new Job(i, jobs[i][0], jobs[i][1]));
                    used[i] = true;
                    jobCount++;
                }
            }

            if (pq.isEmpty()) {
                time++;
                continue;
            }

            Job now = pq.poll();


            if (time < now.request) {
                time = now.request;
            }

            time += now.time;

            sum += (time - now.request);
        }

        return sum / n;
    }

    class Job {

        int index;
        int request;
        int time;

        public Job(int index, int request, int time) {
            this.index = index;
            this.request = request;
            this.time = time;
        }
    }
}
