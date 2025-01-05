package src.programmers.lv1;

public class Problem29 {

    public int solution(int[] number) {
        int count = 0;
        int firstIndex = 0;
        int secondIndex = firstIndex + 1;
        int thirdIndex = firstIndex + 2;

        while (true) {
            if (number[firstIndex] + number[secondIndex] + number[thirdIndex] == 0) count++;

            if (thirdIndex != number.length - 1) {
                thirdIndex++;
            } else if (secondIndex != number.length - 2) {
                secondIndex++;
                thirdIndex = secondIndex + 1;
            } else if (firstIndex != number.length - 3) {
                firstIndex++;
                secondIndex = firstIndex + 1;
                thirdIndex = firstIndex + 2;
            } else {
                break;
            }
        }

        return count;
    }
}
