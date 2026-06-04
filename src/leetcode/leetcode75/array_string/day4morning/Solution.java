package src.leetcode.leetcode75.array_string.day4morning;

public class Solution {

    // Can Place Flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (flowerbed.length == 1) {
            return (flowerbed[0] == 0 && n < 2) || n == 0;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) break;

            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }

                continue;
            }

            if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }

                continue;
            }

            if (flowerbed[i] == 1) continue;

            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
