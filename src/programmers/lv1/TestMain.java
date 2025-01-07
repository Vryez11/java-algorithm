package src.programmers.lv1;

public class TestMain {

    public static void main(String[] args) {

        Problem36 test = new Problem36();

        String[] str = new String []{"abzcd","cdzab","abzfg","abzaa","abzbb","bbzaa"};

        System.out.println("abzcd".compareTo("abzbb"));
        String[] solution = test.solution(str, 2);
    }
}
