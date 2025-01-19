package src.programmers.lv2;

public class Problem5 {

    int zeroCount;

    //이진 변환 반복하기
    public int[] solution(String s) {
        zeroCount = 0;
        int whileCount = 0;

        while (!s.equals("1")) {
            whileCount++;
            s = removeZero(s);
            s = changeLen(s);
        }

        int[] res = {whileCount, zeroCount};
        return res;
    }

    private String removeZero(String s) {
        char[] sArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : sArr) {
            if (c == '0') {
                zeroCount++;
            } else {
                sb.append(1);
            }
        }
        return sb.toString();
    }

    private String changeLen(String s) {
        int len = s.length();
        return Integer.toBinaryString(len);
    }
}
