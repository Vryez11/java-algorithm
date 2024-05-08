package src.programmers;

public class Programmers7Ref {
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

        Programmers7DirMoveClass process = new Programmers7DirMoveClass(startX, startY, arrMap);

        for (String route : routes) {
            String dir = route.split(" ")[0];
            String amount = route.split(" ")[1];
            int temp = Integer.parseInt(amount);
            //움직임 메서드 구현
            process.move(dir, temp);
        }

        int[] answer = {process.getStartX(), process.getStartY()};
        return answer;
    }
}
