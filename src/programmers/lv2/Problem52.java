package src.programmers.lv2;

public class Problem52 {

    // 2개 이하로 다른 비트
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];

            if ((number & 1) == 0) { // 짝수인 경우 +1이 정답
                result[i] = number + 1;
            } else {
                long lowestZeroBit = (~number) & (number + 1); // 가장 낮은 0 비트 찾기
                result[i] = number + lowestZeroBit - (lowestZeroBit >> 1);
            }
        }

        return result;
    }
}
