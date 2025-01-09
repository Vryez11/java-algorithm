package src.programmers.lv1;

public class Problem41 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        int goalCount = 0;

        while (i <= cards1.length - 1 && j <= cards2.length - 1) {
            if (cards1[i].equals(goal[goalCount])) {
                goalCount++;
                i++;
            } else if (cards2[j].equals(goal[goalCount])) {
                goalCount++;
                j++;
            } else return "No";
            if (goalCount > goal.length - 1) return "Yes";
        }
        while (i <= cards1.length - 1) {
            if (cards1[i].equals(goal[goalCount])) {
                goalCount++;
                i++;
            } else return "No";
            if (goalCount > goal.length - 1) return "Yes";
        }
        while (j <= cards2.length - 1) {
            if (cards2[j].equals(goal[goalCount])) {
                goalCount++;
                j++;
            } else return "No";
            if (goalCount > goal.length - 1) return "Yes";
        }

        return "No";
    }
}
