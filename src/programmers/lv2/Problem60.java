package src.programmers.lv2;

import java.util.PriorityQueue;

public class Problem60 {

    // 연속된 부분 수열의 합
    public int[] solution(int[] sequence, int k) {

        int now = 0;
        int next = 0;
        int sum = sequence[now];

        PriorityQueue<sNode> pq = new PriorityQueue<>();

        while (now <= next) {

            if (sum == k) {
                pq.offer(new sNode(now, next));
                sum -= sequence[now++];
            } else if (sum < k && next < sequence.length - 1) {
                sum += sequence[++next];
            } else {
                sum -= sequence[now++];
            }
        }

        sNode result = pq.poll();
        return new int[] {result.startIndex, result.endIndex};
    }

    static class sNode implements Comparable<sNode> {
        int startIndex;
        int endIndex;
        int length;

        public sNode(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.length = endIndex - startIndex;
        }

        @Override
        public int compareTo(sNode o) {
            if (this.length == o.length) {
                return this.startIndex - o.startIndex;
            } else {
                return this.length - o.length;
            }
        }
    }
}
