package src.programmers.lv2;

public class Problem71 {

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        m = replaceSharpNotes(m);

        for (String info : musicinfos) {
            String[] details = info.split(",");
            int playTime = getPlayTime(details[0], details[1]);
            String title = details[2];
            String melody = replaceSharpNotes(details[3]);

            String playedMelody = generatePlayedMelody(melody, playTime);

            if (playedMelody.contains(m) && playTime > maxPlayTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private int getPlayTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");

        int startMinutes = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int endMinutes = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);

        return endMinutes - startMinutes;
    }

    private String replaceSharpNotes(String melody) {
        return melody.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

    private String generatePlayedMelody(String melody, int playTime) {
        StringBuilder playedMelody = new StringBuilder();

        for (int i = 0; i < playTime; i++) {
            playedMelody.append(melody.charAt(i % melody.length()));
        }

        return playedMelody.toString();
    }
}
