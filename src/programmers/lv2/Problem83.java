package src.programmers.lv2;

public class Problem83 {

    // 우박수열 정적분
    public double[] solution(int k, int[][] ranges) {

        double[] answer = new double[ranges.length];

        int cnt = count(k);

        double[] yValue = new double[cnt + 1];
        yValue[0] = k;
        for (int i = 1; i <= cnt; i++) {
            double pre = yValue[i - 1];
            yValue[i] = calYValue(pre);
        }

        double[] area = new double[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            area[i] = (yValue[i - 1] + yValue[i]) / 2;
        }

        double[] S = new double[cnt + 1];
        S[1] = area[1];
        for (int i = 2; i <= cnt; i++) {
            S[i] = S[i - 1] + area[i];
        }

        for (int i = 0; i < ranges.length; i++) {
            int s = ranges[i][0];
            int e = ranges[i][1] + cnt;

            if (e > s) {
                double val = S[e] - S[s];
                String str = String.format("%.1f", val);
                answer[i] = Double.parseDouble(str);
            } else if (s > e) {
                answer[i] = -1.0;
            } else {
                answer[i] = 0.0;
            }
        }

        return answer;
    }

    private int count(int k) {
        int cnt = 0;
        while (k > 1) {
            if (k % 2 == 0) k /= 2;
            else k = (k * 3) + 1;
            cnt++;
        }
        return cnt;
    }

    private double calYValue(double pre) {
        if (pre % 2 == 0)
            return pre / 2;
        else
            return pre * 3 + 1;
    }
}
