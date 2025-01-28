package src.programmers.lv2;

import java.util.Arrays;

public class Problem24 {

    // H-Index
    public int solution(int[] citations) {

        Arrays.sort(citations);
        int hIndex = 1;
        while (hIndex <= citations.length) {
            if (citations[citations.length - hIndex] >= hIndex) {
                hIndex++;
            } else {
                break;
            }
        }

        return hIndex - 1;
    }
}
