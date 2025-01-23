package src.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class Problem15 {

    //영어 끝말잇기
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        char lastChar = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (lastChar == words[i].charAt(0) && !set.contains(words[i])) {
                lastChar = words[i].charAt(words[i].length() - 1);
                set.add(words[i]);
            } else {
                int real = i + 1;
                int count = real % n == 0 ? real / n : real / n + 1;
                int people = real % n == 0 ? n : real % n;

                return new int[]{people, count};
            }
        }

        return new int[]{0, 0};
    }
}
