package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem57 {

    // 다리를 지나는 트럭
    public int solution (int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> queue = new ArrayDeque<>();

        int currentTime = 0;
        int currentTruckCount = 0;
        int currentTruckWeight = 0;
        int waitIndex = 0;

        queue.offer(new Truck(currentTime, truck_weights[0]));
        currentTime++;
        currentTruckCount++;
        currentTruckWeight += truck_weights[waitIndex];
        waitIndex++;

        while (!queue.isEmpty()) {

            while (!queue.isEmpty() && queue.peek().entryTime + bridge_length == currentTime) {
                Truck truck = queue.poll();
                currentTruckWeight -= truck.truck_weight;
                currentTruckCount--;
            }

            if (currentTruckCount < bridge_length && waitIndex < truck_weights.length && currentTruckWeight + truck_weights[waitIndex] <= weight) {
                queue.offer(new Truck(currentTime, truck_weights[waitIndex]));
                currentTruckCount++;
                currentTruckWeight += truck_weights[waitIndex];
                waitIndex++;
            }

            currentTime++;
        }

        return currentTime;
    }

    static class Truck {
        int entryTime;
        int truck_weight;

        public Truck(int entryTime, int truck_weight) {
            this.entryTime = entryTime;
            this.truck_weight = truck_weight;
        }
    }
}
