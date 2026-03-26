package src.programmers.lv2;

import java.util.*;

public class Problem93 {

    // [후보키]
    public int solution(String[][] relation) {
        int rowCount = relation.length;
        int colCount = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>();
        for (int bit = 1; bit < (1 << colCount); bit++) {

            boolean isMinimal = true;
            for (int key : candidateKeys) {
                if ((bit & key) == key) {
                    isMinimal = false;
                    break;
                }
            }

            if (!isMinimal) continue;

            Set<String> set = new HashSet<>();

            for (int i = 0; i < rowCount; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < colCount; j++) {
                    if ((bit & (1 << j)) != 0) {
                        sb.append(relation[i][j]).append(",");
                    }
                }

                set.add(sb.toString());
            }

            if (set.size() == rowCount) {
                candidateKeys.add(bit);
            }
        }

        return candidateKeys.size();
    }
}