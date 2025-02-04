package src.baekjoon.doit.graphSection.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem52 {

    private static int[] A;
    private static List<Integer>[] B;
    private static int truthNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int counter = 0;
        A = new int[N + 1];
        B = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            B[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[T];
        truthNode = N + 1;
        for (int i = 0; i < T; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
            if (i >= 1) {
                truthUnion(truePeople[i - 1], truePeople[i]);
            }
            truthNode = Math.min(truthNode, truePeople[i]);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int[] participant = new int[count];
            for (int j = 0; j < count; j++) {
                participant[j] = Integer.parseInt(st.nextToken());
                B[i].add(participant[j]);
                if (j >= 1) {
                    union(participant[j - 1], participant[j]);
                }
            }
        }
        br.close();

        for (List<Integer> list : B) {
            for (int i = 0; i < list.size(); i++) {
                if (find(list.get(i)) == truthNode) {
                    break;
                }
                if (i == list.size() - 1) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

    private static void truthUnion(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) A[b] = a;
            else A[a] = b;
        }
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a == truthNode) {
                A[b] = truthNode;
            } else if (b == truthNode) {
                A[a] = truthNode;
            } else {
                if (a < b) {
                    A[b] = a;
                } else {
                    A[a] = b;
                }
            }
        }
    }
    private static int find(int a) {
        if (A[a] == truthNode) return truthNode;
        else if (a == A[a]) return A[a];
        else return A[a] = find(A[a]);
    }
}
