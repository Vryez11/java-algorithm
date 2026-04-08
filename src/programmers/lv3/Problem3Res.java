package src.programmers.lv3;

public class Problem3Res {

    // 네트워크 - DFS
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers, visited);
                networkCount++;
            }
        }

        return networkCount;
    }

    private void dfs(int now, int n, int[][] computers, boolean[] visited) {
        visited[now] = true;

        for (int next = 0; next < n; next++) {
            if (now == next) continue;
            
            if (computers[now][next] == 1 && !visited[next]) {
                dfs(next, n, computers, visited);
            }
        }
    }
}