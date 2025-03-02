package src.programmers.lv2;

import java.util.*;

public class Problem70 {

    // 배달
    public int solution(int N, int[][] roads, int K) {
        List<Town>[] towns = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            towns[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            towns[road[0]].add(new Town(road[1], road[2]));
            towns[road[1]].add(new Town(road[0], road[2])); // 수정된 부분
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.currentCost));
        pq.add(new City(1, 0));

        while (!pq.isEmpty()) {
            City now = pq.poll();

            if (now.currentCost > dist[now.index]) continue;

            for (Town town : towns[now.index]) {
                int newCost = now.currentCost + town.cost;

                if (newCost < dist[town.value]) {
                    dist[town.value] = newCost;
                    pq.add(new City(town.value, newCost));
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) res++;
        }

        return res;
    }

    static class Town {
        int value;
        int cost;

        public Town(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    static class City {
        int index;
        int currentCost;

        public City(int index, int currentCost) {
            this.index = index;
            this.currentCost = currentCost;
        }
    }
}
