package src.baekjoon.level.twentieth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon151 {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] signs = new int[4];

    private static void dfs(int idx, int num) {

        if (idx == N) {
            if (max < num) max = num;
            if (min > num) min = num;
            return;
        }

        if (idx == 0) {
            dfs(idx + 1, nums[idx]);
            return;
        }

        for (int i = 0; i < signs.length; i++) {
            if (signs[i] == 0) continue;

            if (i == 0) {
                signs[i]--;
                dfs(idx + 1, num + nums[idx]);
                signs[i]++;
            }

            if (i == 1) {
                signs[i]--;
                dfs(idx + 1, num - nums[idx]);
                signs[i]++;
            }

            if (i == 2) {
                signs[i]--;
                dfs(idx + 1, num * nums[idx]);
                signs[i]++;
            }

            if (i == 3) {
                signs[i]--;
                dfs(idx + 1, num / nums[idx]);
                signs[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < signs.length; i++) {
            signs[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(max);
        System.out.println(min);
    }
}
