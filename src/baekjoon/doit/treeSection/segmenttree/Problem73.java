package src.baekjoon.doit.treeSection.segmenttree;

import java.io.*;
import java.util.StringTokenizer;

public class Problem73 {
    private static long[] tree;
    private static int startNodeIndex;
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int k = 0;
        int powNumber = 1;
        while (powNumber < N) {
            powNumber *= 2;
            k++;
        }
        startNodeIndex = powNumber;
        tree = new long[startNodeIndex * 2];

        for (int i = 0; i < N; i++) {
            tree[startNodeIndex + i] = Long.parseLong(br.readLine());
        }

        initTree();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                updateTree(b, c);
            } else {
                long result = queryTree(b, c);
                bw.write(result + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void initTree() {
        for (int i = startNodeIndex - 1; i >= 1; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
        }
    }

    private static void updateTree(int index, int newValue) {
        int currentIndex = startNodeIndex + index - 1;
        tree[currentIndex] = newValue;

        while (currentIndex > 1) {
            currentIndex /= 2;
            tree[currentIndex] = (tree[currentIndex * 2] * tree[currentIndex * 2 + 1]) % MOD;
        }
    }

    private static long queryTree(int left, int right) {
        int start = startNodeIndex + left - 1;
        int end = startNodeIndex + right - 1;
        long result = 1;

        while (start <= end) {
            if (start % 2 == 1) {
                result = (result * tree[start]) % MOD;
                start++;
            }
            if (end % 2 == 0) {
                result = (result * tree[end]) % MOD;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
    }
}