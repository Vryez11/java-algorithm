package src.baekjoon.level.fourteenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baekjoon106 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<String> login = new TreeSet<>((o1, o2) -> o2.compareTo(o1)); // 내림차순 정렬
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
                login.add(name);
            } else {
                login.remove(name);
            }
        }
        br.close();

        for (String name : login) {
            System.out.println(name);
        }
    }
}
