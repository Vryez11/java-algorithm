package src.programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class Problem43 {

    public int solution(int[] nums) {
        int n = nums.length / 2;

        Set<Integer> mySet = new HashSet<>();

        for (Integer poke : nums) {
            mySet.add(poke);
        }

        if (mySet.size() < n) {
            return mySet.size();
        } else {
            return n;
        }
    }
}
