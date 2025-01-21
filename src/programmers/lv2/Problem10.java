package src.programmers.lv2;

public class Problem10 {

    //카펫
    public int[] solution(int brown, int yellow) {
        int length = 3;
        int width = (brown - 2 * length) / 2 + 2;

        int[] res = dfs(length, width, brown, yellow);

        return res;
    }

    public int[] dfs(int length, int width, int brown, int yellow) {
        if ((length - 2) * (width - 2) == yellow) return new int[]{width, length};
        if (width < 3) return null;

        return dfs(++length, (brown - 2 * length) / 2 + 2, brown, yellow);
    }
}
