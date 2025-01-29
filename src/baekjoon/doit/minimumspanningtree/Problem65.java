package src.baekjoon.doit.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem65 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[] parents;
    private static int[][] maps;
    private static boolean[][] visited;
    private static PriorityQueue<Edge> graph;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        for (int i = 0; i < maps.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < maps[i].length; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int islandNumber = 2;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (numbering(i, j) == 1) {
                    maps[i][j] = islandNumber;
                    islandNumber++;
                } else if (maps[i][j] != 0){
                    maps[i][j] = numbering(i, j);
                }
            }
        }
        parents = new int[islandNumber];
        for (int i = 2; i < parents.length; i++) {
            parents[i] = i;
        }
        graph = new PriorityQueue<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] != 0) {
                    edgeAdd(i, j, maps[i][j]);
                }
            }
        }
        int useEdge = 0;
        int result = 0;

        while (!graph.isEmpty() && useEdge < islandNumber - 3) {
            Edge edge = graph.poll();
            int island1 = edge.x;
            int island2 = edge.y;
            int value = edge.value;

            if (find(island1) != find(island2)) {
                result += value;
                union(island1, island2);
                useEdge++;
            }
        }
        if (useEdge == islandNumber - 3) System.out.println(result);
        else System.out.println(-1);
    }

    private static void edgeAdd(int i, int j, int number) {
        int tempY = i;
        int tempX = j;
        int moveCount = 0;
        // 우로 이동
        while (isValidIndex(++j, i)) {
            moveCount++;
            if (maps[i][j] == number) break;
            if (maps[i][j] != 0) {
                if (moveCount == 2) break;
                graph.add(new Edge(number, maps[i][j], moveCount - 1));
                break;
            }
        }
        // 좌로 이동
        i = tempY;
        j = tempX;
        moveCount = 0;
        while (isValidIndex(--j, i)) {
            moveCount++;
            if (maps[i][j] == number) break;
            if (maps[i][j] != 0) {
                if (moveCount == 2) break;
                graph.add(new Edge(number, maps[i][j], moveCount - 1));
                break;
            }
        }
        i = tempY;
        j = tempX;
        moveCount = 0;
        // 위로 이동
        while (isValidIndex(j, ++i)) {
            moveCount++;
            if (maps[i][j] == number) break;
            if (maps[i][j] != 0) {
                if (moveCount == 2) break;
                graph.add(new Edge(number, maps[i][j], moveCount - 1));
                break;
            }
        }
        i = tempY;
        j = tempX;
        moveCount = 0;
        // 아래로 이동
        while (isValidIndex(j, --i)) {
            moveCount++;
            if (maps[i][j] == number) break;
            if (maps[i][j] != 0) {
                if (moveCount == 2) break;
                graph.add(new Edge(number, maps[i][j], moveCount - 1));
                break;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
        }
    }
    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    private static int numbering(int y, int x) {
        int number = maps[y][x];
        visited = new boolean[N][M];
        return findNumber(y, x, number);
    }
    private static int findNumber(int y, int x, int number) {
        visited[y][x] = true;
        for (int i = 0; i < dx.length; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (isValidIndex(moveX, moveY)) {
                if (maps[moveY][moveX] > 1) {
                    number = maps[moveY][moveX];
                    break;
                } if (maps[moveY][moveX] == 1) {
                    if (!visited[moveY][moveX]) {
                        number = findNumber(moveY, moveX, number);
                        visited[moveY][moveX] = true;
                    }
                }
            }
        }
        return number;
    }
    private static boolean isValidIndex(int moveX, int moveY) {
        return moveX >= 0 && moveX < maps[0].length && moveY >= 0 && moveY < maps.length;
    }

    private static class Edge implements Comparable<Edge> {
        private int x;
        private int y;
        private int value;

        public Edge(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}