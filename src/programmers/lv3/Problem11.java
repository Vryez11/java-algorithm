package src.programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem11 {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, play));
        }

        List<String> genreOrder = new ArrayList<>(genrePlayCount.keySet());
        genreOrder.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> answerList = new ArrayList<>();

        for (String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);

            Collections.sort(songs, (a, b) -> {
                if (b.play != a.play) {
                    return b.play - a.play;
                }
                return a.index - b.index;
            });

            answerList.add(songs.get(0).index);
            if (songs.size() > 1) {
                answerList.add(songs.get(1).index);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    static class Song {
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}