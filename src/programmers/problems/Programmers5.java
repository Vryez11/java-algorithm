package src.programmers.problems;

import java.util.Arrays;

class Programmers5 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        Index index = new Index();

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                if (index.minY > i) index.minY = i;
                if (index.minX > wallpaper[i].indexOf("#")) index.minX = wallpaper[i].indexOf("#");
                if (index.maxY < i+1) index.maxY = (i+1);
                if (index.maxX < (wallpaper[i].indexOf("#") + 1)) index.maxX = (wallpaper[i].indexOf("#") + 1);
                while (true) {
                    wallpaper[i] = wallpaper[i].replaceFirst("#", ".");
                    if (wallpaper[i] == wallpaper[i].replaceAll("#", ".")) break;
                    if (index.maxX < (wallpaper[i].indexOf("#") + 1)) index.maxX = (wallpaper[i].indexOf("#") + 1);
                }
            }
        }

        answer[0] = index.minY;
        answer[1] = index.minX;
        answer[2] = index.maxY;
        answer[3] = index.maxX;

        return answer;
    }
}

class Index {
    int minX = 50;
    int minY = 50;
    int maxX;
    int maxY;
}
