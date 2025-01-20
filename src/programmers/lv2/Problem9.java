package src.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {

    //짝지어 제거하기
    public int solution(String s) {
        char[] sArr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : sArr) {
            list.add(c);
        }
        int index = 1;
        char temp = list.get(0);
        while (index < list.size()) {
            if (temp == list.get(index)) {
                list.remove(index - 1);
                list.remove(index - 1);
                if (list.size() > 1) {
                    temp = list.get(0);
                    index = 1;
                } else {
                    break;
                }
                continue;
            }
            temp = list.get(index);
            index++;
        }
        return list.isEmpty() ? 1 : 0;
    }
}
