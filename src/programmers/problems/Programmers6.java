package src.programmers.problems;

import java.util.Map;
import java.util.HashMap;

class Programmers6 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //누가 누구를 신고했는지 저장하기 위한 2차원 배열
        int[][] reportNumber = new int[id_list.length][id_list.length];
        //id_list의 이름에 키값 부여
        Map<String, Integer> idMap = new HashMap<String, Integer>();
        for(int i = 0; i < id_list.length; i++){
            idMap.put(id_list[i], i);
        }

        //누가 누구를 신고했는지 2차원 배열에 증감 형태로 구현 (숫자는 1를 초과 하지 않는다 : 한 사람은 다른 사람을 신고를 한번 밖에 못한다)
        for (int i = 0; i < report.length; i++) {
            String tempRepoter = report[i].split(" ")[0];
            String tempPerpetrator = report[i].split(" ")[1];

            int repoterIndex = idMap.get(tempRepoter);
            int perpetratorIndex = idMap.get(tempPerpetrator);

            if (reportNumber[repoterIndex][perpetratorIndex] != 1) reportNumber[repoterIndex][perpetratorIndex]++;
        }

        //위해서 정리한 2차원 배열을 for을 통해 temp(임시 증감 변수)가 k이상이면 answer인덱스에 증감
        for (int i = 0; i < reportNumber.length; i++) {
            int temp = 0;
            for (int j = 0; j < reportNumber[i].length; j++) {
                if (reportNumber[j][i] == 1) temp++;
            }
            if (temp >= k) {
                for (int q = 0; q < reportNumber.length; q ++) {
                    if (reportNumber[q][i] == 1) answer[q]++;
                }
            }
        }

        return answer;
    }
}