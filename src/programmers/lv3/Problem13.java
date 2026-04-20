package src.programmers.lv3;

import java.util.*;

public class Problem13 {

    List<String>[] candidates;
    Set<Integer> result;
    Map<String, Integer> userIndexMap;

    public int solution(String[] user_id, String[] banned_id) {
        candidates = new ArrayList[banned_id.length];
        result = new HashSet<>();
        userIndexMap = new HashMap<>();

        for (int i = 0; i < user_id.length; i++) {
            userIndexMap.put(user_id[i], i);
        }

        for (int i = 0; i < banned_id.length; i++) {
            candidates[i] = new ArrayList<>();
            for (String user : user_id) {
                if (validUser(user, banned_id[i])) {
                    candidates[i].add(user);
                }
            }
        }

        dfs(0, 0, user_id, banned_id);

        return result.size();
    }

    private void dfs(int depth, int bitmask, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            result.add(bitmask);
            return;
        }

        for (String user : candidates[depth]) {
            int idx = userIndexMap.get(user);

            if ((bitmask & (1 << idx)) != 0) {
                continue;
            }

            dfs(depth + 1, bitmask | (1 << idx), user_id, banned_id);
        }
    }

    private boolean validUser(String u_id, String b_id) {
        if (u_id.length() != b_id.length()) return false;

        for (int i = 0; i < u_id.length(); i++) {
            if (b_id.charAt(i) == '*') continue;
            if (u_id.charAt(i) != b_id.charAt(i)) return false;
        }

        return true;
    }
}