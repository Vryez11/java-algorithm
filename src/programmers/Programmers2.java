package src.programmers;

class Programmers2 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int initHealth = health;
        int endTime = attacks[attacks.length-1][0];
        int[] attackTime = new int[endTime+1];
        int healTime = 0;
        int attackTemp = 0;

        for (int i = 0; i < attacks.length; i++) {
            int tempTime = attacks[i][0];
            attackTime[tempTime]++;
        }

        for (int i = 1; i <= endTime; i++){
            if (initHealth <= 0) return -1;
            if (attackTime[i] != 1) {
                if (initHealth < health) {
                    initHealth += bandage[1];
                    healTime++;
                    if (healTime == bandage[0]) {
                        initHealth += bandage[2];
                        healTime = 0;
                    }
                    if (initHealth >= health) initHealth = health;
                }
                else {
                    healTime++;
                    if (healTime == bandage[0]) {
                        initHealth += bandage[2];
                        healTime = 0;
                    }
                    if (initHealth >= health) initHealth = health;
                }
            }
            else {
                initHealth -= attacks[attackTemp][1];
                healTime = 0;
                attackTemp++;
            }
        }
        if (initHealth <= 0) return -1;
        else return initHealth;
    }
}