package src.programmers.lv1;

public class Problem40 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] tmp = new String[n];
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            tmp[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            res[i] = "";
        }

        for (int i = 0; i < n; i++) {
            if (tmp[i].length() >= n) {
                tmp[i] = tmp[i].substring(0, n);
            } else {
                for (int j = 0; j < n - tmp[i].length() + 1; j++) {
                    tmp[i] = "0" + tmp[i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i].charAt(j) == '1') {
                    res[i] = res[i] + "#";
                } else {
                    res[i] = res[i] + " ";
                }
            }
        }

        return res;
    }
}
