package src.baekjoon.doit.number.prime;

import java.util.Scanner;

public class Problem40 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long min = input.nextLong();
        long max = input.nextLong();
        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start_index = min / pow; //min에서 가장 가까운 pow 찾기
            if (min % pow != 0) // 나머지가 있으면 +1 해줘야함.
                start_index++;
            for (long j = start_index; pow * j <= max; j++) {
                check[(int)(pow * j - min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < check.length; i++) {
            if (!check[i])
                count++;
        }
        System.out.println(count);
    }
}
