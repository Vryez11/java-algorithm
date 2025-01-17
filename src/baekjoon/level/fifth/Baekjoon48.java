package src.baekjoon.level.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon48 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        br.close();

        int sum = 0;

        char[] strArray = str.toCharArray();
        for (char c : strArray) {
            sum += changeNumber(c);
        }

        System.out.println(sum);
    }

    private static int changeNumber(char ch) {
        switch(ch) {
            case 'A' , 'B' , 'C' : return 3;
            case 'D' , 'E' , 'F' : return 4;
            case 'G' , 'H' , 'I' : return 5;
            case 'J' , 'K' , 'L' : return 6;
            case 'M' , 'N' , 'O' : return 7;
            case 'P' , 'Q' , 'R' , 'S' : return 8;
            case 'V' , 'T' , 'U' : return 9;
            case 'W' , 'X' , 'Y' , 'Z' : return 10;
            default : return 0;
        }
    }
}
