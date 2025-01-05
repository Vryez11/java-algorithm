package src.programmers.lv1;

public class Problem24 {

    public int[] solution(int n, int m) {
        int maxMod = 0;
        int minMult = 0;

        int maxInt = Math.max(n, m);
        int minInt = Math.min(n, m);

        for (int i = maxInt; i > 0; i--) {
            if (maxInt % i == 0 && minInt % i == 0){
                maxMod = i;
                break;
            }
        }

        minMult = maxMod * (maxInt / maxMod) * (minInt / maxMod);

        return new int[]{maxMod, minMult};
    }
}
