package src.programmers.problems;

class Programmers3 {
    public int solution(String[] babbling) {
        int answer = 0;
        //String 배열에 옹알이 종류 4개 저장
        String[] babble = {"aya", "ye", "woo", "ma"};

        //향상된 for문 사용하여 입력된 babbling을 사용
        for(String str1 : babbling) {
            int count = 0;
            for(String str2 : babble) {
                while (true) {
                    String tempstr = str1;
                    //저장한 String 배열에서 이를 하나씩 대조하여 앞에 옹알이만 1로 변환
                    str1 = str1.replaceFirst(str2, "1");
                    //count를 증감하므로써 나중에 1의 갯수를 확인하는데 사용
                    if (tempstr != str1) count++;
                    else break;
                }
            }
            //변환된 str1과의 비료를 위한 for문
            String tempstr1 = "";
            for (int i = 0; i < count; i++) {
                tempstr1 += "1";
            }
            //문자열이 1이고 count갯수와 맞으면 answer 갯수 증감
            if (str1.equals(tempstr1)) answer++;
        }
        return answer;
    }
}