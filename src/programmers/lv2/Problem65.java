package src.programmers.lv2;

public class Problem65 {

    // 124 나라의 숫자
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = {4, 1, 2};

        while (n > 0) {
            int remainder = n % 3;
            n /= 3;

            if (remainder == 0) {
                n--;
            }

            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }
}
