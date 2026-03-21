package src.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class Problem90 {
    Set<Set<Integer>> sets;

    public int solution(int n, int[][] q, int[] ans) {
        sets = new HashSet<>();
        Set<Set<Integer>> antiSet = new HashSet<>();
        dfs(n, 1, 0, new HashSet<>());

        for(int i = 0; i < q.length; i++) {
            for (Set<Integer> set : sets) {

                int tmp = 0;
                for (int j = 0; j < q[i].length; j++) {
                    if (set.contains(q[i][j])) {
                        tmp++;
                    }
                }

                if (tmp != ans[i]) {
                    antiSet.add(set);
                }
            }

            if (!antiSet.isEmpty()) {
                for (Set<Integer> set : antiSet) {
                    sets.remove(set);
                }
            }
        }

        return sets.size();
    }

    private void dfs(int n, int start, int depth, Set<Integer> set) {
        if (depth == 5) {
            sets.add(new HashSet<>(set));
            return;
        }

        for (int i = start; i <= n; i++) {
            set.add(i);
            dfs(n, i + 1, depth + 1, set);
            set.remove(i);
        }
    }
}