package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

class Problem64Ref {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] arr = new int[friends.length][friends.length];
        int[] giftIndex = new int[friends.length];
        //Map을 키: 이름, 값: 인겍스로 저장
        Map <String, Integer> giftMap = new HashMap<String, Integer>();
        for (int i = 0; i < friends.length; i++) {
            giftMap.put(friends[i], i);
        }
        //Map을 이용하여 arr2차원 배열과 선물지수 저장
        for(String gift : gifts) {
            String Jun = gift.split(" ")[0];
            String Bab = gift.split(" ")[1];
            giftIndex[giftMap.get(Jun)]++;
            giftIndex[giftMap.get(Bab)]--;

            arr[giftMap.get(Jun)][giftMap.get(Bab)]++;
        }

        //위에서 계산한 arr 2차원 배열과 giftIndex 배열을 이용하여 monthGift 배열에 다음 달 선물 갯수를 계산하여 저장
        int[] monthGift = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i < j) {
                    if (arr[i][j] > arr[j][i]) monthGift[i]++;
                    else if (arr[i][j] < arr[j][i]) monthGift[j]++;
                    else {
                        if (giftIndex[i] > giftIndex[j]) monthGift[i]++;
                        else if(giftIndex[i] < giftIndex[j]) monthGift[j]++;
                        else continue;
                    }
                }
            }
        }

        //monthGift의 제일 큰 수를 찾아 answer에 대입
        for(int i = 0; i <friends.length; i++) {
            if (monthGift[i] > answer) answer = monthGift[i];
        }


        return answer;
    }
}