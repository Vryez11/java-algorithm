package src.programmers.lv2;

import java.util.*;

public class Problem38 {

    // [3차] 압축
    public List<Integer> solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 'A'; i <= (int) 'Z'; i++) {
            dict.put(Character.toString((char)i), dict.size() + 1);
        }

        char[] chars = msg.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            if (i < chars.length - 1) {
                if (!dict.containsKey(sb.toString() + chars[i + 1])) {
                    list.add(dict.get(sb.toString()));
                    dict.put(sb.toString() + chars[i + 1], dict.size() + 1);
                    sb = new StringBuilder();
                }
            } else {
                list.add(dict.get(sb.toString()));
            }
        }
        return list;
    }
}
