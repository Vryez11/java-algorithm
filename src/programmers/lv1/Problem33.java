package src.programmers.lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem33 {

    public int[] solution(int[] numbers) {
        Set<Integer> mySet = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                mySet.add(numbers[i] + numbers[j]);
            }
        }

        int[] res = new int[mySet.size()];
        int index = 0;

        for (Integer num : mySet) {
            res[index++] = num;
        }

        Arrays.sort(res);

        return res;
    }
}
