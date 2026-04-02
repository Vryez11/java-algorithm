package src.programmers.lv2;

public class Problem99 {

    // 숫자 블록
    public int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin) + 1];
        int idx = 0;

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                answer[idx++] = 0;
                continue;
            }

            if (isPrime(i)) {
                answer[idx++] = 1;
                continue;
            }

            if (i > 10_000_000) {
                for (long j = 10_000_000; j > 1; j--) {
                    if (i % j ==0) {
                        answer[idx++] = (int) j;
                        break;
                    }
                }
            } else {
                for (long j = i - 1; j > 1; j--) {
                    if (i % j == 0) {
                        answer[idx++] = (int) j;
                        break;
                    }
                }
            }

        }

        return answer;
    }

    private boolean isPrime(long num) {

        for (long i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
