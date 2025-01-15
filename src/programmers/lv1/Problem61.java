package src.programmers.lv1;

import java.util.Arrays;

public class Problem61 {

    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];
        int count = 0;

        for (int student : lost) {
            students[student]--;
        }

        for (int student : reserve) {
            students[student]++;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] == -1 && students[i - 1] == 1) {
                students[i]++;
                students[i - 1]--;
            } else if (students[i] == -1 && i != n && students[i + 1] == 1) {
                students[i]++;
                students[i + 1]--;
            }
        }

        System.out.println(Arrays.toString(students));

        for (int i = 1; i <= n; i++) {
            if (students[i] > -1) count++;
        }

        return count;
    }
}
