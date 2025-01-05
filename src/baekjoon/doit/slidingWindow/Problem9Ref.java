package src.baekjoon.doit.slidingWindow;

import java.util.Scanner;

public class Problem9Ref {

    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();
        int count = 0;
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        char[] strArr = sc.next().toCharArray();
        for (int i = 0; i < 4; i++) {
            checkArr[i] = sc.nextInt();
            if (checkArr[i] == 0)
                checkSecret++;
        }
        for (int i = 0; i < P; i++) {
            ADD(strArr[i]);
        }
        if (checkSecret == 4)
            count++;
        for (int i = P; i < S; i++) {
            int j = i - P;
            ADD(strArr[i]);
            Remove(strArr[j]);
            if (checkSecret == 4)
                count++;
        }
        System.out.println(count);
    }

    private static void ADD(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
