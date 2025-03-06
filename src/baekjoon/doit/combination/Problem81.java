package src.baekjoon.doit.combination;

import java.util.*;

public class Problem81 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int problemType = input.nextInt();

        if (problemType == 1) {
            long k = input.nextLong();
            findKthPermutation(N, k);
        } else {
            int[] givenPermutation = new int[N];
            for (int i = 0; i < N; i++) {
                givenPermutation[i] = input.nextInt();
            }
            findPermutationOrder(N, givenPermutation);
        }
    }

    private static void findKthPermutation(int N, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--;

        StringBuilder result = new StringBuilder();
        for (int i = N; i > 0; i--) {
            int index = (int)(k / factorial[i - 1]);
            result.append(numbers.get(index)).append(" ");
            numbers.remove(index);
            k %= factorial[i - 1];
        }

        System.out.println(result.toString().trim());
    }

    private static void findPermutationOrder(int N, int[] givenPermutation) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long order = 1;
        for (int i = 0; i < N; i++) {
            int index = numbers.indexOf(givenPermutation[i]);
            order += index * factorial[N - i - 1];
            numbers.remove(index);
        }

        System.out.println(order);
    }
}
