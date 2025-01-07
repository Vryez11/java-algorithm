package src.programmers.lv1;

public class Problem35 {

    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= food.length - 1 ; i++) {
            food[i] /= 2;
            for (int j = 0; j < food[i]; j++) {
                sb.append((i));
            }
        }

        String res = sb.toString();
        res += "0" + sb.reverse();

        return res;
    }
}
