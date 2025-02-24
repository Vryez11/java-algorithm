package src.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class Problem56 {

    // 소수 찾기
    public int solution(String numbers) {
        int[] primes = new int[(int) Math.pow(10, numbers.length())];

        for (int i = 2; i < primes.length; i++) {
            primes[i] = i;
        }
        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i] == i) {
                for (int j = i + i; j < primes.length; j = j + i) {
                    primes[j] = 0;
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];
        generatePermutations("", numbers, used, set);

        int primeCount = 0;
        for (int num : set) {
            if (primes[num] != 0) {
                primeCount++;
            }
        }

        return primeCount;
    }

    private void generatePermutations(String current, String numbers, boolean[] used, Set<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(current + numbers.charAt(i), numbers, used, set);
                used[i] = false;
            }
        }
    }
}
