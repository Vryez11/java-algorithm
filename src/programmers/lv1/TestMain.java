package src.programmers.lv1;

public class TestMain {

    public static void main(String[] args) {

        Problem41 test = new Problem41();

        String[] cards1 = new String[]{"i", "water", "drink"};
        String[] cards2 = new String[]{"want", "to"};
        String[] goal = new String[]{"i", "want", "to", "drink", "water"};

        String solution = test.solution(cards1, cards2, goal);
        System.out.println(solution);
    }
}
