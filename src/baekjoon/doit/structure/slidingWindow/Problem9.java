package src.baekjoon.doit.structure.slidingWindow;

import java.util.Scanner;

public class Problem9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        int startIndex = 0;
        int endIndex = startIndex + M - 1;
        String DNA = sc.next();
        int[] dnaConditions = new int[4];
        int[] tempArr = new int[4];
        for (int i = 0; i < 4; i++) {
            dnaConditions[i] = sc.nextInt();
        }
        for(int i = startIndex; i <= endIndex; i++) {
            tempArr[dnaNum(DNA.charAt(i))]++;
        }
        if(isPW(dnaConditions, tempArr)) count++;

        while(endIndex < N - 1) {
            tempArr[dnaNum(DNA.charAt(startIndex))]--;
            startIndex++;
            endIndex++;
            tempArr[dnaNum(DNA.charAt(endIndex))]++;
            if(isPW(dnaConditions, tempArr)) count++;
        }
        System.out.println(count);
    }

    private static int dnaNum(char dna) {
        if (dna == 'A') return 0;
        else if (dna == 'C') return 1;
        else if (dna == 'G') return 2;
        else return 3;
    }
    private static boolean isPW(int[] conditions, int[] tempPW) {
        if (tempPW[0] < conditions[0]) return false;
        if (tempPW[1] < conditions[1]) return false;
        if (tempPW[2] < conditions[2]) return false;
        return tempPW[3] >= conditions[3];
    }
}
