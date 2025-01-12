package src.programmers.lv1;

public class Problem52 {

    public int solution(String[] bubbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String str : bubbling) {
            if (str.contains(words[0] + words[0])) continue;
            if (str.contains(words[1] + words[1])) continue;
            if (str.contains(words[2] + words[2])) continue;
            if (str.contains(words[3] + words[3])) continue;
            for (int i = 0; i < words.length; i++) {
                str = str.replaceAll(words[i], " ");
            }
            str = str.replaceAll(" ", "");
            if (str.isEmpty()) count++;
        }

        return count;
    }
}
