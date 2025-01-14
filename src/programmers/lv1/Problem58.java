package src.programmers.lv1;

import java.util.Arrays;

public class Problem58 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] res = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            char[] targetArray = targets[i].toCharArray();
            int[] keyIndex = new int[keymap.length];
            int count = 0;

            for (char c : targetArray) {
                for (int j = 0; j < keymap.length; j++) {
                    if (keymap[j].contains(String.valueOf(c))) {
                        keyIndex[j] = keymap[j].indexOf(c) + 1;
                    } else {
                        keyIndex[j] = 101;
                        count++;
                    }
                }
                res[i] += Arrays.stream(keyIndex).min().getAsInt();
                if (count == keymap.length){
                    res[i] = -1;
                    break;
                }
                count = 0;
            }
        }
        return res;
    }
}
