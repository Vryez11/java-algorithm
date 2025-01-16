package src.programmers.lv1;

public class Problem72 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int menu = 0;
        int len = 0;
        int wid = 0;
        int whileNum = n - 1;

        for(int i = 0; i < answer.length; i++) {
            answer[len][wid] = num++;
            if (i != answer.length - 1) wid++;
        }

        while(whileNum > 0) {
            if (menu++ % 2 == 0){
                for (int i = 0; i < whileNum; i++){
                    len++;
                    answer[len][wid] = num++;
                }
                for (int i = 0; i < whileNum; i++){
                    wid--;
                    answer[len][wid] = num++;
                }
            } else {
                for (int i = 0; i < whileNum; i++){
                    len--;
                    answer[len][wid] = num++;
                }
                for (int i = 0; i < whileNum; i++){
                    wid++;
                    answer[len][wid] = num++;
                }
            }
            whileNum--;
        }

        return answer;
    }
}