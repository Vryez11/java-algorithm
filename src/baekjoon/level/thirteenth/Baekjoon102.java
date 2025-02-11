package src.baekjoon.level.thirteenth;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon102 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<User> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            pq.add(new User(age, name, i));
        }

        while (!pq.isEmpty()) {
            User user = pq.poll();
            bw.write(user.age + " " + user.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class User implements Comparable<User> {
        int age;
        String name;
        int index;

        public User(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        @Override
        public int compareTo(User o) {
            if (this.age == o.age) {
                return Integer.compare(this.index, o.index);
            } else {
                return Integer.compare(this.age, o.age);
            }
        }
    }
}
