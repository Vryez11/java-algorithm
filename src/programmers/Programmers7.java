package src.programmers;

public class Programmers7 {
    public int[] solution(String[] park, String[] routes) {
        //park 배열에서 가로와 세로의 크기를 추출
        int length = park.length;
        int width = park[0].length();
        //시작지점을 저장하기 위한 변수
        int startX = 0, startY = 0;

        //length와 width를 이용하여 2차원 정수 배열을 생성
        int[][] arrMap = new int [length][width];

        //for문을 통해 routes의 시작지점, 이동 가능한 통로, 장애물 각각 1, 0, -1로 지정
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    arrMap[i][j]++;
                    startX = j;
                    startY = i;
                }
                else if (park[i].charAt(j) == 'O') continue;
                else arrMap[i][j]--;
            }
        }

        //routes 대로 E, W, N, S을 조건문으로 나누고 이동하는 로직
        for (String route : routes) {
            String dir = route.split(" ")[0];
            String amount = route.split(" ")[1];
            int temp = Integer.parseInt(amount);
            //움직임 메서드 구현
            if (dir.equals("E")) {
                for (int i = 1; i <= temp; i++) {
                    //인덱스 범위 벗어나는 것 주의!
                    //먼저 로봇이 있는 곳과 움직일 i 거리를 계산해서 세로, 가로에 벗어나면 break 후에 장애물이 나타마녀 break 순서 주의
                    if ((startX + i) > arrMap[0].length-1) break;
                    if (arrMap[startY][startX+i] == -1) break;
                    if (i == temp) {
                        startX += i;
                    }
                }
            } else if (dir.equals("W")) {
                for (int i = 1; i <= temp; i++) {
                    if ((startX - i) < 0) break;
                    if (arrMap[startY][startX-i] == -1) break;
                    if (i == temp) {
                        startX -= i;
                    }
                }
            } else if (dir.equals("N")) {
                for (int i = 1; i <= temp; i++) {
                    if ((startY - i) < 0) break;
                    if (arrMap[startY-i][startX] == -1) break;
                    if (i == temp) {
                        startY -= i;
                    }
                }
            } else {
                for (int i = 1; i <= temp; i++) {
                    if ((startY + i) > arrMap.length-1) break;
                    if (arrMap[startY+i][startX] == -1) break;
                    if (i == temp) {
                        startY += i;
                    }
                }
            }
        }

        int[] answer = {startY, startX};
        return answer;
    }
}
