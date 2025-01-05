package src.programmers.lv1;

public class Problem6 {

    public boolean solution(int x) {
        boolean answer = true;
        int divNum = 0;
        int tempX = x;

        while (tempX > 0) {
            divNum += tempX % 10;
            tempX = tempX / 10;
        }

        return x % divNum == 0;
    }
}
