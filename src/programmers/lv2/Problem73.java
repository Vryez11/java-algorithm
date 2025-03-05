package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class Problem73 {

    // 줄 서는 방법
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            int index = (int) (k / fact);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= fact;
        }

        return answer;
    }
}
