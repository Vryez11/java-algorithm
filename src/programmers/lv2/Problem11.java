package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem11 {

    //구명보트
    public int solution(int[] people, int limit) {

        int boatCount = 0;
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int person : people) {
            deque.offerLast(person);
        }
        while (!deque.isEmpty()) {
            if (deque.peekFirst() + deque.peekLast() > limit) {
                deque.pollLast();
                boatCount++;
            } else {
                Integer minWeight = deque.pollFirst();
                if (!deque.isEmpty()) {
                    Integer maxWeight = deque.pollLast();
                }
                boatCount++;
            }
        }

        return boatCount;
    }
}
