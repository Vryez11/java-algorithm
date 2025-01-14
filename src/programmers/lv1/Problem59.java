package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Problem59 {

    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String winner : completion) {
            map.put(winner, map.getOrDefault(winner, 0) + 1);
        }

        for (String challenger : participant) {
            if(!map.containsKey(challenger))
                return challenger;
            else
                map.put(challenger, map.get(challenger) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() !=  0)
                return entry.getKey();
        }
        return "false";
    }
}
