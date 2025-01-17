package src.baekjoon.level.fifth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon49 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        ArrayList<String> map = new ArrayList<>();

        while(input.hasNext()){
            map.add(input.nextLine());
        }

        for (String s : map) {
            System.out.println(s);
        }
    }
}
