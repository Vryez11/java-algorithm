package src.baekjoon.level.eighteenth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baekjoon137 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        if (N == 1) {
            int num = input.nextInt();
            System.out.println(num);
            System.out.println(num);
            System.out.println(num);
            System.out.println(0);
            return;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int[] arr = new int[N];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mode = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();

            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            if (countMap.get(arr[i]) > count) {
                count = countMap.get(arr[i]);
            }
            sum += arr[i];
            if (min > arr[i]) min = arr[i];
            if (max < arr[i]) max = arr[i];
        }

        Arrays.sort(arr);

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (countMap.get(arr[i]) == count) {
                if (flag) {
                    mode = arr[i];
                    break;
                }

                i += (count - 1);
                flag = true;
                mode = arr[i];
            }
        }

        int average = (int) Math.round((double) sum / N);

        System.out.println(average);
        System.out.println(arr[N/2]);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
