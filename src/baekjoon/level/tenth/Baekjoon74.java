package src.baekjoon.level.tenth;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon74 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        Map<Integer, Integer>[] maps = new Map[2];
        maps[0] = new HashMap<>();
        maps[1] = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maps[0].put(x, maps[0].getOrDefault(x, 0) + 1);
            maps[1].put(y, maps[1].getOrDefault(y, 0) + 1);
        }
        br.close();

        for (Map<Integer, Integer> map : maps) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    bw.write(entry.getKey() + " ");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
