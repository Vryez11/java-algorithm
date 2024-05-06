package src.programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers11 {
    public static String solution(String[] survey, int[] choices) {
        int[] arr4Personality = new int[4];
        
        Map<Integer, Integer> amountMap = new HashMap<Integer, Integer>();
        for(int i = 1; i < 8; i++){
            if (i == 1) amountMap.put(i, 3);
            else if (i == 2) amountMap.put(i, i);
            else if (i == 3) amountMap.put(i, 1);
            else if (i == 4) amountMap.put(i, 0);
            else amountMap.put(i, -(i-4));
        }
        
        for (int i = 0 ; i < survey.length; i++) {
            if (survey[i].contains("R")) {
                if (survey[i].indexOf("R") == 0) {
                    arr4Personality[0] += amountMap.get(choices[i]);
                } else {
                    arr4Personality[0] -= amountMap.get(choices[i]);
                }
            } else if (survey[i].contains("C")) {
                if (survey[i].indexOf("C") == 0) {
                    arr4Personality[1] += amountMap.get(choices[i]);
                } else {
                    arr4Personality[1] -= amountMap.get(choices[i]);
                }
            } else if (survey[i].contains("J")) {
                if (survey[i].indexOf("J") == 0) {
                    arr4Personality[2] += amountMap.get(choices[i]);
                } else {
                    arr4Personality[2] -= amountMap.get(choices[i]);
                }
            } else {
                if (survey[i].indexOf("A") == 0) {
                    arr4Personality[3] += amountMap.get(choices[i]);
                } else {
                    arr4Personality[3] -= amountMap.get(choices[i]);
                }
            }
        }

        String answer = "";
        answer += (arr4Personality[0] >= 0) ? "R" : "T";
        answer += (arr4Personality[1] >= 0) ? "C" : "F";
        answer += (arr4Personality[2] >= 0) ? "J" : "M";
        answer += (arr4Personality[3] >= 0) ? "A" : "N";
        
        return answer;
    }
}
