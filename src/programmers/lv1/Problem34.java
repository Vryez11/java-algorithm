package src.programmers.lv1;

import java.util.HashMap;

public class Problem34 {

    HashMap<String, Integer> myMap = new HashMap<>();

    public int solution(String s) {

        mapCreate();
        for (String string : myMap.keySet()) {
            if (s.contains(string)) {
                s = s.replaceAll(string, String.valueOf(myMap.get(string)));
            }
        }
        return Integer.parseInt(s);
    }

    private void mapCreate() {
        myMap.put("zero", 0);
        myMap.put("one", 1);
        myMap.put("two", 2);
        myMap.put("three", 3);
        myMap.put("four", 4);
        myMap.put("five", 5);
        myMap.put("six", 6);
        myMap.put("seven", 7);
        myMap.put("eight", 8);
        myMap.put("nine", 9);
    }
}
