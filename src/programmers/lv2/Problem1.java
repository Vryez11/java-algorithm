package src.programmers.lv2;

import java.util.Arrays;

public class Problem1 {
    // 최댓값과 최솟값

    public String solution(String s) {
        String[] split = s.split(" ");
        int[] arr = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);

        return sb.toString();
    }
}
