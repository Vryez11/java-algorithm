package src.programmers.lv2;

import java.util.*;

public class Problem16 {

    //귤 고르기
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        Collection<Integer> values = map.values();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2) * -1);
        for (Integer value : values) {
            pq.offer(value);
        }
        int quantity = 0;
        int count = 0;
        while (quantity < k) {
            quantity += pq.poll();
            count++;
        }

        return count;
    }
}
