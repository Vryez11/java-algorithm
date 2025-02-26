package src.programmers.lv2;

public class Problem61 {

    // 마법의 엘리베이터
    public int solution(int storey) {
        int stoneCount = 0;

        while (storey > 0) {
            int remainder = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (remainder > 5 || (remainder == 5 && nextDigit >= 5)) {
                stoneCount += (10 - remainder);
                storey += (10 - remainder);
            } else {
                stoneCount += remainder;
            }

            storey /= 10;
        }

        return stoneCount;
    }
}
