package src.baekjoon.sw;

import java.io.*;
import java.util.*;

public class Problem2 {

    // 계단 오르기
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int [N + 1];

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Queue<Player> q = new ArrayDeque<>();
        q.offer(new Player(1, stairs[1], 1));
        q.offer(new Player(1, stairs[2], 2));

        int maxValue = 0;

        while (!q.isEmpty()) {
            Player now = q.poll();

            if (now.height == N) {
                maxValue = Math.max(maxValue, now.currentValue);
                continue;
            }

            if (!(now.sq > 1)) {
                q.offer(new Player(now.sq + 1, now.currentValue + stairs[now.height + 1], now.height + 1));
            }
            if (!(now.height + 2 > N)) {
                q.offer(new Player(1, now.currentValue + stairs[now.height + 2], now.height + 2));
            }
        }

        System.out.println(maxValue);
    }

    static class Player {
        int sq;
        int currentValue;
        int height;

        public Player(int sq, int currentValue, int height) {
            this.sq = sq;
            this.currentValue = currentValue;
            this.height = height;
        }
    }
}
