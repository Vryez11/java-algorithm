package src.programmers;

class Programmers3 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] babble = {"aya", "ye", "woo", "ma"};

        for(String str1 : babbling) {
            int count = 0;
            for(String str2 : babble) {
                while (true) {
                    String tempstr = str1;
                    str1 = str1.replaceFirst(str2, "1");
                    if (tempstr != str1) count++;
                    else break;
                }
            }
            String tempstr1 = "";
            for (int i = 0; i < count; i++) {
                tempstr1 += "1";
            }
            if (str1.equals(tempstr1)) answer++;
        }
        return answer;
    }
}