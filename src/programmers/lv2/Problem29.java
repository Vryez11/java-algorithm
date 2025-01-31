package src.programmers.lv2;

import java.util.Arrays;

public class Problem29 {

    // 전화번호 목록
    public boolean solution(String[] phone_book) {
        // 1. 전화번호 목록을 정렬
        Arrays.sort(phone_book);

        // 2. 앞뒤 번호를 비교하여 접두사인지 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
