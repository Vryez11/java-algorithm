package src.programmers.lv2;

public class Problem99Ref {

    // 숫자 블록 리팩토링
    public int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin + 1)];
        int idx = 0;

        for (long num = begin; num <= end; num++) {
            if (num == 1) {
                answer[idx++] = 0;
                continue;
            }

            answer[idx++] = findBlock(num);
        }

        return answer;
    }

    private int findBlock(long num) {
        int result = 1;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long pair = num / i;
                if (pair <= 10_000_000) {
                    return (int) pair;
                }

                result = (int) i;
            }
        }

        return result;
    }
}
