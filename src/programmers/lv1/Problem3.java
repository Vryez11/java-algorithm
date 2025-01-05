package src.programmers.lv1;

public class Problem3 {

    boolean solution(String s) {
        int Pnum = 0;
        int Ynum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p') Pnum++;
            else if (c == 'P') Pnum++;
            else if (c == 'y') Ynum++;
            else if (c == 'Y') Ynum++;
        }

        return Pnum == Ynum;
    }
}
