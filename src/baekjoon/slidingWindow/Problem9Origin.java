package src.baekjoon.slidingWindow;

import java.util.Scanner;

public class Problem9Origin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int startIndex = 0;
        int endIndex = startIndex + M;
        String DNA = sc.next();
        int[] dnaConditions = new int[4];
        for (int i = 0; i < 4; i++) {
            dnaConditions[i] = sc.nextInt();
        }

        while(endIndex <= N) {
            String tempPW = DNA.substring(startIndex, endIndex);
            if (isPW(tempPW, dnaConditions)) {
                count++;
            }
            startIndex++;
            endIndex++;
        }
        System.out.println(count);
    }

    private static boolean isPW(String tempPW, int[] dnaConditions) {
        char[] charArray = tempPW.toCharArray();
        int[] tempArr = new int[4];
        for (char c : charArray) {
            if (c == 'A') tempArr[0]++;
            else if (c == 'C') tempArr[1]++;
            else if (c == 'G') tempArr[2]++;
            else tempArr[3]++;
        }
        for (int i = 0; i < 4; i++) {
            if (tempArr[i] < dnaConditions[i]) return false;
        }
        return true;
    }
}
