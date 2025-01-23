package src.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class Problem18 {

    //연속 부분 수열 합의 개수
    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        int sequenceSize = 1;

        while(sequenceSize <= elements.length) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = 0; j < sequenceSize; j++) {
                    sum += elements[(i + j) % elements.length];
                }
                set.add(sum);
            }
            sequenceSize++;
        }

        return set.size();
    }
}
