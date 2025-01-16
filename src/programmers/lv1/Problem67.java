package src.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

class Problem67 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> nameRank = new HashMap<String, Integer>();
        Map<Integer, String> rankName = new HashMap<Integer, String>();

        for(int i=0; i < players.length; i++){
            rankName.put(i,players[i]);
            nameRank.put(players[i],i);
        }

        for(String call : callings) {
            int playerRank = nameRank.get(call);
            String previousName = rankName.get(playerRank-1);
            rankName.replace(playerRank-1, call);
            rankName.replace(playerRank, previousName);
            nameRank.replace(call, playerRank-1);
            nameRank.replace(previousName, playerRank);
        }

        for(int i = 0; i < players.length; i++){
            answer[i] = rankName.get(i);
        }
        return answer;
    }
}
