package src.programmers.lv1;

public class Problem46 {

    public int[] solution(int[] answers) {
        int[] testee1 = new int[] {1, 2, 3, 4, 5};
        int[] testee2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] testee3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        int correctCount1 = 0;
        int correctCount2 = 0;
        int correctCount3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (testee1[index1] == answers[i]) {
                correctCount1++;
            }
            if (testee2[index2] == answers[i]) {
                correctCount2++;
            }
            if (testee3[index3] == answers[i]) {
                correctCount3++;
            }

            index1 = (index1 + 1) % testee1.length;
            index2 = (index2 + 1) % testee2.length;
            index3 = (index3 + 1) % testee3.length;
        }

        int arrayCount = 0;
        int max = Math.max(correctCount1, Math.max(correctCount2, correctCount3));
        if (max == correctCount1) arrayCount++;
        if (max == correctCount2) arrayCount++;
        if (max == correctCount3) arrayCount++;

        int[] res = new int[arrayCount];

        if (arrayCount == 1) {
            if (max == correctCount1) res[0] = 1;
            else if (max == correctCount2) res[0] = 2;
            else res[0] = 3;
        } else if (arrayCount == 3) {
            res[0] = 1;
            res[1] = 2;
            res[2] = 3;
        } else {
            if (max == correctCount1) res[0] = 1;
            else res[0] = 2;

            if (max == correctCount3) res[1] = 3;
            else res[1] = 2;
        }

        return res;
    }
}
