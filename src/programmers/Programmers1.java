package src.programmers;

class Programmers1 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] arr = new int[friends.length][friends.length];

        for (String str : gifts) {
            String Jun = str.split(" ")[0];
            String Bab = str.split(" ")[1];

            for (int i = 0; i < friends.length; i++) {
                if (Jun.equals(friends[i])){
                    for (int j = 0; j < friends.length; j++) {
                        if (Bab.equals(friends[j])) arr[i][j]++;
                    }
                }
            }
        }

        int[] giftIndex = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            int Jun = 0, Bab = 0;
            for (int j = 0; j < friends.length; j ++) {
                Jun += arr[i][j];
                Bab += arr[j][i];
            }
            giftIndex[i] = Jun - Bab;
        }

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

        for(int i = 0; i <friends.length; i++) {
            if (monthGift[i] > answer) answer = monthGift[i];
        }


        return answer;
    }
}