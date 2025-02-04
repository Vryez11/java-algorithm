package src.baekjoon.doit.treeSection.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem71 {

    private static long[] A;
    private static long[] segmentTree;
    private static int segmentStartIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }
        initArr(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                updateArr(b, c);
            } else {
                sb.append(prefixSum(b, (int) c)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static void initArr(int N) {
        int k = 0;
        int tempN = 1;
        while (tempN < N) {
            k++;
            tempN = (int) Math.pow(2, k);
        }
        segmentTree = new long[(int) Math.pow(2, k) * 2];
        segmentStartIndex = (int) Math.pow(2, k) - 1;
        for (int i = 1; i <= N; i++) {
            segmentTree[segmentStartIndex + i] = A[i];
        }
        for (int i = segmentStartIndex - 1; i >= 1; i--) {
            segmentTree[i] = segmentTree[i * 2] + segmentTree[i * 2 + 1];
        }
    }

    private static void updateArr(int index, long value) {
        int updateIndex = segmentStartIndex + index;
        segmentTree[updateIndex] = value;

        while (updateIndex > 1) {
            updateIndex /= 2;
            segmentTree[updateIndex] = segmentTree[updateIndex * 2] + segmentTree[updateIndex * 2 + 1];
        }
    }

    private static long prefixSum(int start, int end) {
        int startIndex = segmentStartIndex + start;
        int endIndex = segmentStartIndex + end;
        long prefixSum = 0;

        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) prefixSum += segmentTree[startIndex];
            if (endIndex % 2 == 0) prefixSum += segmentTree[endIndex];

            startIndex = (startIndex + 1) / 2;
            endIndex = (endIndex - 1) / 2;
        }
        return prefixSum;
    }
}
