package src.programmers.lv1;

public class Problem57 {

    public String solution(String s, String skip, int index) {
        char[] sArray = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sArray.length; i++) {
            char sChar = (char) ((int)sArray[i]);

            for (int j = 0; j < index; j++) {
                sChar = (char) (sChar + 1);
                if (sChar > 'z') {
                    sChar = (char) (sChar - 'z' + 'a' - 1);
                }
                while (skip.contains(String.valueOf(sChar))) {
                    sChar = (char) (sChar + 1);
                    if (sChar > 'z') {
                        sChar = (char) (sChar - 'z' + 'a' - 1);
                    }
                }
            }
            sb.append(sChar);
        }
        return sb.toString();
    }
}
