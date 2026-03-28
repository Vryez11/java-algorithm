package src.programmers.lv3;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem1 {

    // 이중우선순위큐
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int size = 0;

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minPQ.offer(num);
                maxPQ.offer(num);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                size++;
            } else {
                if (size == 0) continue;

                if (num == 1) {
                    removeValidTop(maxPQ, countMap);
                } else {
                    removeValidTop(minPQ, countMap);
                }
                size--;
            }
        }

        cleanTop(minPQ, countMap);
        cleanTop(maxPQ, countMap);

        if (size == 0) {
            return new int[]{0, 0};
        }

        return new int[]{maxPQ.peek(), minPQ.peek()};
    }

    private void removeValidTop(PriorityQueue<Integer> pq, HashMap<Integer, Integer> countMap) {
        cleanTop(pq, countMap);

        if (!pq.isEmpty()) {
            int value = pq.poll();
            countMap.put(value, countMap.get(value) - 1);
        }
    }

    private void cleanTop(PriorityQueue<Integer> pq, HashMap<Integer, Integer> countMap) {
        while (!pq.isEmpty()) {
            int value = pq.peek();
            if (countMap.getOrDefault(value, 0) > 0) break;
            pq.poll();
        }
    }
}