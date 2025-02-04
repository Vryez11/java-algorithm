package src.baekjoon.doit.treeSection.segmenttree;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem72 {
    private static int[] tree;
    private static int treeSize;
    private static int treeFirstNodeIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int k = 1;
        while (k < N) {
            k *= 2;
        }
        treeSize = k * 2;
        tree = new int[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);

        treeFirstNodeIndex = k;

        for (int i = 0; i < N; i++) {
            tree[treeFirstNodeIndex + i] = Integer.parseInt(br.readLine());
        }

        buildTree();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(query(a - 1, b - 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void buildTree() {
        for (int i = treeFirstNodeIndex - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    private static int query(int left, int right) {
        int minValue = Integer.MAX_VALUE;

        left += treeFirstNodeIndex;
        right += treeFirstNodeIndex;

        while (left <= right) {
            if (left % 2 == 1) {
                minValue = Math.min(minValue, tree[left]);
                left++;
            }
            if (right % 2 == 0) {
                minValue = Math.min(minValue, tree[right]);
                right--;
            }
            left /= 2;
            right /= 2;
        }

        return minValue;
    }
}
