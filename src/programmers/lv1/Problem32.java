package src.programmers.lv1;

public class Problem32 {

    public int[] solution(String s) {
        char[] sArray = s.toCharArray();
        int[] res = new int[sArray.length];

        for (int i = 0; i < sArray.length; i++) {
            int tempIndex = i - 1;
            while (tempIndex >= 0) {
                if (sArray[tempIndex] == sArray[i]) {
                    break;
                }
                tempIndex--;
            }
            res[i] = tempIndex < 0 ? - 1: i - tempIndex;
        }

        return res;
    }
}
