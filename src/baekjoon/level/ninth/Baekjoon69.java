package src.baekjoon.level.ninth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon69 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[1001];
        for (int i = 2; i < nums.length; i++) {
            nums[i] = i;
        }
        for (int i = 2; i < Math.sqrt(1000); i++) {
            if (nums[i] == i) {
                int count = 2;

                while (i * count <= nums.length - 1) {
                    if (nums[i * count] != - 1)
                        nums[i * count] = -1;
                    count++;
                }
            }
        }
        int result = 0;
        for (int i : arr) {
            if (nums[i] == i) result++;
        }

        System.out.println(result);
        br.close();
    }
}
