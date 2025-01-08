package src.programmers.lv1;

public class TestMain {

    public static void main(String[] args) {

        Problem40 test = new Problem40();

        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {6, 7, 8, 9, 10};

        String[] solution = test.solution(5, a, b);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
