package src.programmers.lv2;

public class Problem3 {

    public String solution(String s) {

        char[] sArray = s.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            if (i == 0) {
                if (sArray[i] >= 'a' && sArray[i] <= 'z') {
                    sArray[i] = (char) (sArray[i] - 32);
                }
                continue;
            }

            if (sArray[i - 1] == ' ') {
                if (sArray[i] >= 'a' && sArray[i] <= 'z') {
                    sArray[i] = (char) (sArray[i] - 32);
                }
                continue;
            }

            if (sArray[i] >= 'A' && sArray[i] <= 'Z') {
                sArray[i] = (char) (sArray[i] + 32);
            }
        }

        return new String(sArray);
    }
}
