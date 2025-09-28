package src.baekjoon.level.eighteenth;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon135 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        String[] message = new String[N];

        for (int i = 0; i < message.length; i++) {
            message[i] = input.next();
        }

        Set<String> group = new HashSet<>();
        int res = 0;

        for (String msg : message) {
            if (msg.equals("ENTER")) {
                res += group.size();
                group.clear();
                continue;
            }
            group.add(msg);
        }

        res += group.size();

        System.out.println(res);
    }
}
