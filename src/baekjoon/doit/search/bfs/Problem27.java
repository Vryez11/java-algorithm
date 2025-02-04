package src.baekjoon.doit.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem27 {

    static boolean[][] miro;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        String[] strings = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            strings[i] = br.readLine();
            for (int j = 1; j <= M; j++) {
                miro[i][j] = strings[i].charAt(j - 1) - '0' == 1;
            }
        }
        br.close();

        Node start = new Node(1, 1, 1);
        Node end = bfs(start);
        System.out.println(end.count);
    }

    private static Node bfs(Node node) {
        Queue<Node> myQueue = new LinkedList<>();
        visited[node.index1][node.index2] = true;
        myQueue.add(node);

        while (!(myQueue.peek().index1 == N && myQueue.peek().index2 == M)) {
            if (myQueue.peek().ifDown() != null) {
                if (!visited[myQueue.peek().index1 + 1][myQueue.peek().index2]) {
                    visited[myQueue.peek().index1 + 1][myQueue.peek().index2] = true;
                    myQueue.add(myQueue.peek().ifDown());
                }
            }
            if (myQueue.peek().ifRight() != null) {
                if (!visited[myQueue.peek().index1][myQueue.peek().index2 + 1]) {
                    visited[myQueue.peek().index1][myQueue.peek().index2 + 1] = true;
                    myQueue.add(myQueue.peek().ifRight());
                }
            }
            if (myQueue.peek().ifUp() != null) {
                if (!visited[myQueue.peek().index1 - 1][myQueue.peek().index2]) {
                    visited[myQueue.peek().index1 - 1][myQueue.peek().index2] = true;
                    myQueue.add(myQueue.peek().ifUp());
                }
            }
            if (myQueue.peek().ifLeft() != null) {
                if (!visited[myQueue.peek().index1][myQueue.peek().index2 - 1]){
                    visited[myQueue.peek().index1][myQueue.peek().index2 - 1] = true;
                    myQueue.add(myQueue.peek().ifLeft());
                    }
            }
            myQueue.poll();
        }
        return myQueue.poll();
    }

    static class Node {
        private int index1;
        private int index2;
        private int count;

        public Node(int i, int j, int count) {
            this.index1 = i;
            this.index2 = j;
            this.count = count;
        }

        public Node ifRight () {
            int nextcount = count;
            if (index2 + 1 <= M && miro[index1][index2 + 1]) {
                return new Node(index1, index2 + 1, ++nextcount);
            } else return null;
        }
        public Node ifLeft () {
            int nextcount = count;
            if (index2 - 1 > 0 && miro[index1][index2 - 1]) {
                return new Node(index1, index2 - 1, ++nextcount);
            } else return null;
        }
        public Node ifDown () {
            int nextcount = count;
            if (index1 + 1 <= N && miro[index1 + 1][index2]) {
                return new Node(index1 + 1, index2, ++nextcount);
            } else return null;
        }
        public Node ifUp () {
            int nextcount = count;
            if (index1 - 1 > 0 && miro[index1 - 1][index2]) {
                return new Node(index1 - 1, index2, ++nextcount);
            } else return null;
        }
    }
}
