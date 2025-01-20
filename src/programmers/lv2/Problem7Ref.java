package src.programmers.lv2;

public class Problem7Ref {

    //다음 큰 숫자
    public int solution(int n) {
        int nCount = oneCount(Integer.toBinaryString(n));
        int resCount = 0;
        while (true) {
            n += 1;
            resCount = oneCount(Integer.toBinaryString(n));
            if (resCount == nCount) break;
        }

        return n;
    }

    private int oneCount(String str) {
        int count = 0;
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c == '1') count++;
        }

        return count;
    }
}
