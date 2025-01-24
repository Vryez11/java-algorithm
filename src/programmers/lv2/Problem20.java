package src.programmers.lv2;

import java.util.*;

public class Problem20 {

    //할인 행사
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> shopping = new HashMap<>();
        int count = 0;
        for (int i = 0; i < want.length; i++) {
            shopping.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> copyShopping = new HashMap<>(shopping);

            for (int j = i; j < i + 10; j++) {
                if (copyShopping.containsKey(discount[j])) {
                    copyShopping.put(discount[j], copyShopping.get(discount[j]) - 1);
                }
            }

            Collection<Integer> values = copyShopping.values();
            List<Integer> list = new ArrayList<>(values);
            for (int k = 0; k < list.size(); k++) {
                if (list.get(k) != 0) break;

                if (k == list.size() - 1) count++;
            }
        }

        return count;
    }
}
