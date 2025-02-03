package src.programmers.lv2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Problem35 {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    // 방문 길이
    public int solution(String dirs) {
        Set<Road> roads = new HashSet<>();
        int currentX = 0; int currentY = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char road = dirs.charAt(i);
            int tempX = currentX; int tempY = currentY;
            if (road == 'U') {
                currentX += dx[0];
                currentY += dy[0];
            } else if (road == 'D') {
                currentX += dx[1];
                currentY += dy[1];
            } else if (road == 'R') {
                currentX += dx[2];
                currentY += dy[2];
            } else {
                currentX += dx[3];
                currentY += dy[3];
            }
            if (currentX <= 5 && currentX >= -5 && currentY <= 5 && currentY >= -5) {
                roads.add(new Road(tempX, tempY, currentX, currentY));
                roads.add(new Road(currentX, currentY, tempX, tempY));
            }
            else {
                currentX = tempX;
                currentY = tempY;
            }
        }

        return roads.size() / 2;
    }

    static class Road {
        int x;
        int y;
        int goalX;
        int goalY;

        public Road(int x, int y, int goalX, int goalY) {
            this.x = x;
            this.y = y;
            this.goalX = goalX;
            this.goalY = goalY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return x == road.x && y == road.y && goalX == road.goalX && goalY == road.goalY;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, goalX, goalY);
        }
    }
}
