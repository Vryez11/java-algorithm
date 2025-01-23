package src.baekjoon.doit.topologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem55Ref {

    private static List<Road>[] roads; // 그래프의 도로를 저장할 리스트
    private static int[] indegree; // 각 노드의 진입 차수
    private static int[] maxDistance; // 출발지부터 각 노드까지의 최대 거리
    private static List<Road>[] reverseRoads; // 역방향 그래프
    private static boolean[] visited; // 최적 경로 역추적 시 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 도로 개수
        roads = new ArrayList[n + 1];
        reverseRoads = new ArrayList[n + 1];
        indegree = new int[n + 1];
        maxDistance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
            reverseRoads[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            roads[start].add(new Road(end, time));
            reverseRoads[end].add(new Road(start, time)); // 역방향 그래프 생성
            indegree[end]++;
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        br.close();

        // 1. 위상 정렬로 최대 시간 계산
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Road road : roads[current]) {
                int next = road.end;
                int time = road.time;

                // 최대 시간 업데이트
                if (maxDistance[next] < maxDistance[current] + time) {
                    maxDistance[next] = maxDistance[current] + time;
                }

                // 진입 차수 감소
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 2. 역방향 그래프에서 최적 경로에 포함된 도로 카운트
        int criticalRoadCount = 0;
        queue.add(endNode);
        visited[endNode] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Road road : reverseRoads[current]) {
                int prev = road.end;
                int time = road.time;

                // 최적 경로에 포함된 도로 확인
                if (maxDistance[current] == maxDistance[prev] + time) {
                    criticalRoadCount++;
                    if (!visited[prev]) {
                        visited[prev] = true;
                        queue.add(prev);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(maxDistance[endNode]); // 최대 시간
        System.out.println(criticalRoadCount); // 최적 경로 도로 수
    }

    static class Road {
        int end;
        int time;

        public Road(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}
