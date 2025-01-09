package src.programmers.lv1;

import java.util.HashMap;

public class Problem42 {

    HashMap<String, Integer> map;

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] score = new int[photo.length];
        map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (map.get(photo[i][j]) != null)
                    score[i] += map.get(photo[i][j]);
            }
        }

        return score;
    }
}
