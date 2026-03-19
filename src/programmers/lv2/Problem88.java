package src.programmers.lv2;

public class Problem88 {

    int[] discounts = {10, 20, 30, 40};
    int[] selected;
    int bestMember = 0;
    int bestSales = 0;

    // 이모티콘 할인행사
    public int[] solution(int[][] users, int[] emoticons) {
        selected = new int[emoticons.length];
        dfs(0, users, emoticons);
        return new int[]{bestMember, bestSales};
    }

    private void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            simulate(users, emoticons);
            return;
        }

        for (int discount : discounts) {
            selected[depth] = discount;
            dfs(depth + 1, users, emoticons);
        }
    }

    private void simulate(int[][] users, int[] emoticons) {
        int member = 0;
        int sales = 0;

        for (int[] user : users) {
            int needRate = user[0];
            int limit = user[1];
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (selected[i] >= needRate) {
                    sum += emoticons[i] * (100 - selected[i]) / 100;
                }
            }

            if (sum >= limit) {
                member++;
            } else {
                sales += sum;
            }
        }

        if (member > bestMember) {
            bestMember = member;
            bestSales = sales;
        } else if (member == bestMember) {
            bestSales = Math.max(sales, bestSales);
        }
    }
}
