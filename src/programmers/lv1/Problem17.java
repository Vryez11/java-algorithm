package src.programmers.lv1;

public class Problem17 {

    public int solution(int left, int right) {
        int sum = 0;
        while (left <= right) {
            if (isMeasureOdd(left)) sum += left;
            else sum -= left;
            left++;
        }

        return sum;
    }

    private boolean isMeasureOdd(int num) {
        int count = 0;
        int envNum = 1;
        while (num >= envNum){
            if (num % envNum == 0) count++;
            envNum++;
        }

        return count % 2 == 0;
    }
}
