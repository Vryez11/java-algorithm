package src.programmers.lv3;

import java.util.*;

public class Problem18 {

    boolean[] used;
    List<String> answer;

    // 여행 경로
    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        used = new boolean[tickets.length];
        answer = new ArrayList<>();

        List<String> route = new ArrayList<>();
        route.add("ICN");

        dfs("ICN", tickets, route, 0);

        return answer.toArray(new String[0]);
    }

    private boolean dfs(String current, String[][] tickets, List<String> route, int count) {
        if (count == tickets.length) {
            answer = new ArrayList<>(route);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                route.add(tickets[i][1]);

                if (dfs(tickets[i][1], tickets, route, count + 1)) {
                    return true;
                }

                route.remove(route.size() - 1);
                used[i] = false;
            }
        }

        return false;
    }
}