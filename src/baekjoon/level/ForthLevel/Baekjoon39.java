package src.baekjoon.level.ForthLevel;

import java.util.Scanner;

public class Baekjoon39 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrNum = new int[10];
        int[] arrMod = new int[10];
        int count = 0;

        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = scanner.nextInt();
        }

        for (int j = 0; j < arrMod.length; j++) {
            arrMod[j] = 42 % arrNum[j];
        }

//        for (int k = 0; k < arrMod.length; k++) {
//            for (int m = k; m < arrMod.length; m++) {
//                if (arrMod[k] != arrMod[m]) {
//                    count++;
//                    break;
//                }
//            }
//        }

        System.out.println(count);
    }
}
