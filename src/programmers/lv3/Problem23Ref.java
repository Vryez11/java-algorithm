package src.programmers.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem23Ref {

    // 디스크 컨트롤러
    public int solution(int[][] jobs) {
        int n = jobs.length;

        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.duration == b.duration) {
                if (a.request == b.request) {
                    return a.index - b.index;
                }
                return a.request - b.request;
            }
            return a.duration - b.duration;
        });

        int time = 0;
        int index = 0;
        int completed = 0;
        int totalTurnaroundTime = 0;

        while (completed < n) {

            while (index < n && jobs[index][0] <= time) {
                pq.offer(new Job(index, jobs[index][0], jobs[index][1]));
                index++;
            }

            if (pq.isEmpty()) {
                time = jobs[index][0];
                continue;
            }

            Job now = pq.poll();

            time += now.duration;
            totalTurnaroundTime += time - now.request;
            completed++;
        }

        return totalTurnaroundTime / n;
    }

    static class Job {
        int index;
        int request;
        int duration;

        public Job(int index, int request, int duration) {
            this.index = index;
            this.request = request;
            this.duration = duration;
        }
    }
}