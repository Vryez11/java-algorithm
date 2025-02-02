package src.programmers.lv2;

public class Problem32 {

    private int result;

    // 타켓 넘버
    public int solution(int[] numbers, int target) {
        result = 0;
        DFS(numbers, target, 0, 0);
        return result;
    }

    private void DFS(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) result++;
            return;
        }

        DFS(numbers, target, index + 1, currentSum + numbers[index]);
        DFS(numbers, target, index + 1, currentSum - numbers[index]);
    }
}
