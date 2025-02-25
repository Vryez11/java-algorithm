package src.programmers.lv2;

public class Problem58 {

    // 삼각 달팽이
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int maxNumber = (n * (n + 1)) / 2;
        int number = 1;

        int x = 0, y = -1;
        int direction = 0;
        int limit = n;

        while (number <= maxNumber) {
            for (int i = 0; i < limit; i++) {
                if (direction == 0) y++;
                else if (direction == 1) x++;
                else { x--; y--; }
                arr[y][x] = number++;
            }
            direction = (direction + 1) % 3;
            limit--;
        }

        int[] answer = new int[maxNumber];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}
