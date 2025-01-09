package src.programmers.lv1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Problem45 {

    public String solution(int a, int b) {

        LocalDate ld = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = ld.getDayOfWeek();
        return String.valueOf(dayOfWeek).substring(0, 3);
    }
}
