package src.programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers8 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //answer을 대입할 배열
        int tmp = 0;
        int[] result = new int[privacies.length];
        //차례로 년/월/일의 값을 저장할 배열
        int[] todayArr = new int[3];
        //String today로부터 .으로 분리하고 이를 Integer로 저장
        for(int i = 0; i < today.split("\\.").length; i++){
            todayArr[i] = Integer.parseInt(today.split("\\.")[i]);
        }
        //유효기간을 키와 값으로 저장할 termsMap
        Map<String, Integer> termsMap = new HashMap<String, Integer>();
        for (String term : terms) {
            termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }
        //위에서 저장한 것을 토대로 문제 해결
        for (int i = 0; i < privacies.length; i++){
            String termKey = privacies[i].split(" ")[1];
            int termInt = termsMap.get(termKey);

            int[] tempToday = new int[privacies[i].split(" ")[0].split("\\.").length];
            for(int j = 0; j < privacies[i].split(" ")[0].split("\\.").length; j++){
                tempToday[j] = Integer.parseInt(privacies[i].split(" ")[0].split("\\.")[j]);
            }
            //개인정보 수집 일자에서 유효기간 더하기
            tempToday[1] += termInt;
            if (tempToday[1] > 12) {
                tempToday[0] += 1;
                tempToday[1] -= 12;
            }
            tempToday[2] -= 1;
            if (tempToday[2] == 0) {
                tempToday[2] = 28;
                tempToday[1] -= 1;
                if (tempToday[1] == 0) {
                    tempToday[1] = 12;
                    tempToday[0] -= 1;
                }
            }
            //현재 날짜와 파기 날짜 비교
            int todayInt = todayArr[0]*12*28 + todayArr[1]*28 + todayArr[2];
            int tempInt = tempToday[0]*12*28 + tempToday[1]*28 + tempToday[2];

            if (todayInt > tempInt) {
                result[tmp] = i + 1;
                tmp++;
            }
        }

        //답 출력 (배열은 값을 쌓을 수가 없어서 다소 귀찮지만 아래와 같은 방법을 생각함
        int[] answer = new int[tmp];
        for(int q = 0; q < tmp; q++){
            answer[q] = result[q];
        }
        return answer;
    }
}