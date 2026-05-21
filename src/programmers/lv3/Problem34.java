package src.programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class Problem34 {

    // 양과 늑대
    private int answer;
    private int[] info;
    private List<Integer>[] tree;

    public int solution(int[] info, int[][] edges) {

        this.info = info;
        answer = 0;
        tree = new ArrayList[info.length];

        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            tree[parent].add(child);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0, 0, 0, nextNodes);

        return answer;
    }

    private void dfs(int current, int sheep, int wolf, List<Integer> nextNodes) {

        if (info[current] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        if (wolf >= sheep) {
            return;
        }

        answer = Math.max(answer, sheep);

        List<Integer> candidates = new ArrayList<>(nextNodes);

        candidates.remove(Integer.valueOf(current));

        for (int child : tree[current]) {
            candidates.add(child);
        }

        for (int next : candidates) {
            dfs(next, sheep, wolf, candidates);
        }
    }
}