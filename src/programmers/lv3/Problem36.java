package src.programmers.lv3;

import java.util.HashMap;
import java.util.Map;

public class Problem36 {

    // 미로 탈출 명령어
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        int absX = Math.abs(r - x);
        int absY = Math.abs(c - y);
        if (absX + absY > k || (k - (absX + absY)) % 2 != 0)
            return "impossible";

        int moveX = x - r;
        int moveY = y - c;
        int moveSum = 0;

        // 0 -> d, 1 -> l, 2 -> r, 3 -> u
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'd');
        map.put(1, 'l');
        map.put(2, 'r');
        map.put(3, 'u');

        int[] characters = new int[4];
        if (moveX < 0) {
            characters[0] = Math.abs(moveX);
            moveSum += characters[0];
        } else {
            characters[3] = moveX;
            moveSum += characters[3];
        }
        if (moveY < 0) {
            characters[2] = Math.abs(moveY);
            moveSum += characters[2];
        } else {
            characters[1] = moveY;
            moveSum += characters[1];
        }

        int curX = x;
        int curY = y;
        StringBuilder sb = new StringBuilder();

        if (moveSum == k) {
            for(int i = 0; i < 4; i++) {
                for (int j = 0; j < characters[i]; j++) {
                    sb.append(map.get(i));
                }
            }

            return sb.toString();
        }

        for (int i = 0; i < characters[0]; i++) {
            sb.append(map.get(0));
            curX++;
        }

        while (curX < n && moveSum < k) {
            curX++;
            sb.append(map.get(0));
            characters[3]++;
            moveSum += 2;
        }

        for (int i = 0; i < characters[1]; i++) {
            sb.append(map.get(1));
            curY--;
        }

        while (curY > 1 && moveSum < k) {
            curY--;
            sb.append(map.get(1));
            characters[2]++;
            moveSum += 2;
        }

        while (moveSum < k) {
            sb.append(map.get(2));
            sb.append(map.get(1));
            moveSum += 2;
        }

        for (int i = 0; i < characters[2]; i++) {
            sb.append(map.get(2));
        }

        for (int i = 0; i < characters[3]; i++) {
            sb.append(map.get(3));
        }

        return sb.toString();
    }
}
