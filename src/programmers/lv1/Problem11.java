package src.programmers.lv1;

public class Problem11 {

    static boolean[] numberBool = new boolean[10];

    public int solution(int[] numbers) {
        int answer = 0;

        for(int i = 0; i < numbers.length; i++) {
            numberBool[numbers[i]] = true;
        }

        for(int i = 0; i < numberBool.length; i++) {
            if(!numberBool[i]) {
                answer += i;
            }
        }

        return answer;
    }
}
