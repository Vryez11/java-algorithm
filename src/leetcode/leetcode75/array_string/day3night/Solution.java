package src.leetcode.leetcode75.array_string.day3night;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int maxCount = 0;
        for (int candy : candies) {
            maxCount = Math.max(maxCount, candy);
        }
        for (int i = 0; i < candies.length; i++) {
            int candy = candies[i];
            if (candy + extraCandies >= maxCount) result.add(true);
            else result.add(false);
        }

        return result;
    }
}
