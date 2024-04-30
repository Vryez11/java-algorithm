package src.programmers;

class Programmers1 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] arr = new int[friends.length][friends.length];

        //준 사람과 받은 사람을 " "을 기준으로 나눠서 저장
        for (String str : gifts) {
            String Jun = str.split(" ")[0];
            String Bab = str.split(" ")[1];

            //준 사람과 받은 사람을 equals 함수를 이용하여 arr인덱스를 찾아서 증감
            for (int i = 0; i < friends.length; i++) {
                if (Jun.equals(friends[i])){
                    for (int j = 0; j < friends.length; j++) {
                        if (Bab.equals(friends[j])) arr[i][j]++;
                    }
                }
            }
        }

        //선물 점수를 계산하여 giftIndex 배열에 저장
        int[] giftIndex = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            int Jun = 0, Bab = 0;
            for (int j = 0; j < friends.length; j ++) {
                Jun += arr[i][j];
                Bab += arr[j][i];
            }
            giftIndex[i] = Jun - Bab;
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