package src.programmers.lv1;

public class Problem19 {

    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += (long) price * (i + 1);
        }
        return sum < money ? 0: sum - money;
    }
}
