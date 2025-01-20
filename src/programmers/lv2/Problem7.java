package src.programmers.lv2;

public class Problem7 {

    //다음 큰 숫자
    public int solution(int n) {
        int res = n + 1;
        int nLen = Integer.toBinaryString(n).replaceAll("0", "").length();
        while (true) {
            int resLen = Integer.toBinaryString(res).replaceAll("0", "").length();
            if (resLen == nLen) {
                break;
            } else {
                res++;
            }
        }
        return res;
    }
}
