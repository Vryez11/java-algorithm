package src.programmers.lv1;

public class Problem49 {

    public int solution(int[] nums) {
        int index1 = 0, index2 = index1 + 1, index3 = index2 + 1;
        int num = 0, count = 0;

        while (index1 <= nums.length - 3) {
            num = nums[index1] + nums[index2] + nums[index3];

            if (index3 < nums.length - 1) {
                index3++;
            } else {
                if (index2 < nums.length - 2) {
                    index2++;
                    index3 = index2 + 1;
                } else {
                    index1++;
                    index2 = index1 + 1;
                    index3 = index2 + 1;
                }
            }
            if (isDecimal(num)) count++;
        }
        return count;
    }

    private boolean isDecimal(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        return cnt <= 2;
    }
}
