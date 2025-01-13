package src.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Problem55 {

    public int[] solution(int[] lottos, int[] win_nums) {

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int lottoIndex = 0, winIndex = 0;
        int correctCount = 0, randomCount = 0;
        int maxCount, minCount;

        while (lottoIndex < lottos.length && winIndex < win_nums.length) {
            if (lottos[lottoIndex] == win_nums[winIndex]) {
                correctCount++;
                lottoIndex++;
                winIndex++;
            } else if (lottos[lottoIndex] > win_nums[winIndex]) {
                winIndex++;
            } else {
                lottoIndex++;
            }
        }

        for (int lotto : lottos) {
            if (lotto == 0) randomCount++;
        }

        maxCount = correctCount + randomCount;
        minCount = correctCount;

        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(6, 1);
        myMap.put(5, 2);
        myMap.put(4, 3);
        myMap.put(3, 4);
        myMap.put(2, 5);
        myMap.put(1, 6);
        myMap.put(0, 6);

        return new int[]{myMap.get(maxCount), myMap.get(minCount)};
    }
}
