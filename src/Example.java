package src;

import src.programmers.Programmers8;
import src.programmers.Programmers9;
import src.programmers.Programmers10;
import src.programmers.Programmers11;
import src.programmers.Programmers12;

public class Example {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80},
                        {2, 20300804, 847, 37},
                        {3, 20300401, 10, 8}};

        int[][] result = Programmers12.solution(data, "date", 20300501, "remain");
    }
}
