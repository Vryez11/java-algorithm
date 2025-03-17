package src.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem78 {

    // 테이블 해시 함수
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int reCol = col - 1;
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[reCol] == o2[reCol]) return o2[0] - o1[0];

                return o1[reCol] - o2[reCol];
            }
        });
        List<Integer> S = new ArrayList<>();
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int Si = 0;
            for (int num : data[i]) {
                Si += num % (i + 1);
            }
            S.add(Si);
        }

        int result = 0;
        for (Integer Si : S) {
            result = result ^ Si;
        }

        return result;
    }
}
