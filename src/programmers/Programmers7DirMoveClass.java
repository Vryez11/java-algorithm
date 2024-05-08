package src.programmers;

public class Programmers7DirMoveClass {
    private int startX;
    private int startY;
    private int[][] arrMap;

    Programmers7DirMoveClass(int startX, int startY, int[][] arrMap) {
        this.startX = startX;
        this.startY = startY;
        this.arrMap = arrMap;
    }
    public int getStartX() {
        return startX;
    }
    public int getStartY() {
        return startY;
    }

    public void move(String dir, int amount) {
        if (dir.equals("E")) eastMove(amount);
        else if (dir.equals("W")) westMove(amount);
        else if (dir.equals("N")) northMove(amount);
        else southMove(amount);
    }

    private void eastMove(int amount) {
        for (int i = 1; i <= amount; i++) {
            //인덱스 범위 벗어나는 것 주의!
            //먼저 로봇이 있는 곳과 움직일 i 거리를 계산해서 세로, 가로에 벗어나면 break 후에 장애물이 나타마녀 break 순서 주의
            if ((startX + i) > arrMap[0].length-1) break;
            if (arrMap[startY][startX+i] == -1) break;
            if (i == amount) {
                startX += i;
            }
        }
    }

    private void northMove(int amount) {
        for (int i = 1; i <= amount; i++) {
            if ((startY - i) < 0) break;
            if (arrMap[startY-i][startX] == -1) break;
            if (i == amount) {
                startY -= i;
            }
        }
    }

    private void southMove(int amount) {
        for (int i = 1; i <= amount; i++) {
            if ((startY + i) > arrMap.length-1) break;
            if (arrMap[startY+i][startX] == -1) break;
            if (i == amount) {
                startY += i;
            }
        }
    }

    private void westMove(int amount) {
        for (int i = 1; i <= amount; i++) {
            if ((startX - i) < 0) break;
            if (arrMap[startY][startX-i] == -1) break;
            if (i == amount) {
                startX -= i;
            }
        }
    }
}
