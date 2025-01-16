package src.programmers.lv1;

class Problem65 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int initHealth = health;  //초기 체력을 현재 채력으로 저장할 변수 설정
        int endTime = attacks[attacks.length-1][0]; //attacks의 배열의 크기를 통해 끝나는 시간 저장
        int[] attackTime = new int[endTime+1]; //attack 하는 시간 만을 attscks 2차원 배열에서 추출해서 저장
        int healTime = 0; //연속적인 회복 시간을 알기 위해 변수 설정
        int attackTemp = 0; //배열의 카운트를 위한 변수

        //for문을 통해 tempTime 변수에 공격 시간을 저장하고 attackTime 인덱스에 1로 표현
        for (int i = 0; i < attacks.length; i++) {
            int tempTime = attacks[i][0];
            attackTime[tempTime]++;
        }

        //위에 준비물을 가지고 endTime까지 for문을 수행
        //현재 initHealth 변수가 0보다 작아지면 return -1하며 끝내기, 이후 attackTime에 저장된 공격 시간을 토대로 공격할 떄, 안할 때 나누어서 알고리즘 진행
        for (int i = 1; i <= endTime; i++){
            if (initHealth <= 0) return -1;
            //공격안할 때
            if (attackTime[i] != 1) {
                //힐 할 때에는 힐량 보다 남은 힐량 보다 적을 떄와 클 때 나누어 실행
                if (initHealth < health) {
                    initHealth += bandage[1];
                    healTime++;
                    //힐 연속 시간이 입력된 시간과 같을 떄
                    if (healTime == bandage[0]) {
                        initHealth += bandage[2];
                        healTime = 0;
                    }
                    if (initHealth >= health) initHealth = health;
                }
                else {
                    healTime++;
                    //힐 연속 시간이 입력된 시간과 같을 떄
                    if (healTime == bandage[0]) {
                        initHealth += bandage[2];
                        healTime = 0;
                    }
                    if (initHealth >= health) initHealth = health;
                }
            }
            //공격할 때
            else {
                initHealth -= attacks[attackTemp][1];
                healTime = 0;
                attackTemp++;
            }
        }
        if (initHealth <= 0) return -1;
        //initHealth 남은 채력 return
        else return initHealth;
    }
}