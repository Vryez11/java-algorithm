package src.programmers.lv2;

public class Problem12 {

    //점프와 순간 이동
    public int solution(int n) {
        int count = 0;

        while(n != 1) {
            if (n % 2 == 0) n /= 2;
            else {
                n -= 1;
                count++;
                n /= 2;
            }
        }
        count++;

        return count;
    }
}
