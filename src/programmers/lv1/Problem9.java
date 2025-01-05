package src.programmers.lv1;

public class Problem9 {

    public int solution(int num) {
        int cnt = 0;
        long num1 = num; //num이 int의 범위를 벗어날 수 있음을 인지해야 하는 문제!

        if (num1 == 1) return 0;
        else {
            while (cnt++ < 500) {
                if (num1 == 1) return --cnt;

                if (num1 % 2 == 0) {
                    num1 = num1 / 2;
                } else {
                    num1 = num1 * 3 + 1;
                }
            }
            return -1;
        }
    }
}
