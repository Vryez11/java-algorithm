package src.baekjoon.doit.sort.bubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numStr = br.readLine();
        char[] charArray = numStr.toCharArray();
        int max;
        int maxIndex;

        for (int i = 0; i < charArray.length - 1; i++) {
            max = 0;
            maxIndex = i;
            for (int j = i; j < charArray.length; j++) {
                if (max < Integer.parseInt(String.valueOf(charArray[j]))) {
                    max = Integer.parseInt(String.valueOf(charArray[j]));
                    maxIndex = j;
                }
            }
            swap(charArray, i, maxIndex);
        }

        System.out.println(String.valueOf(charArray));
        br.close();
    }

    private static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
