package src.baekjoon.doit.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24 {

    private static int N;
    private static int[] nums1 = new int[]{1, 3, 5, 7, 9};
    private static int[] nums2 = new int[]{2, 3, 5, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < nums2.length; i++) {
            dfs("", nums2[i]);
        }
    }

    private static void dfs(String s, int n) {
        String tmp = s + n;

        if (tmp.length() == N) {
            if (isDecimal(Integer.parseInt(tmp))) {
                System.out.println(tmp);
            }
        } else if (tmp.length() < N) {
            if (isDecimal(Integer.parseInt(tmp))) {
                for (int i = 0; i < nums1.length; i++) {
                    dfs(tmp, nums1[i]);
                }
            }
        }
    }

    private static boolean isDecimal(int num) {
        int count =0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
            if (count > 2) return false;
        }
        return true;
    }
}
