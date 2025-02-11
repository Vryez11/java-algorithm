package src.programmers.lv2;

import java.util.*;

public class Problem49 {

    // 오픈채팅방
    public String[] solution(String[] records) {
        List<User> list = new ArrayList<>();
        List<String> messages = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String record : records) {
            String[] recordSplit = record.split(" ");

            if (recordSplit[0].equals("Change")) {
                map.put(recordSplit[1], recordSplit[2]);
            } else {
                if (recordSplit.length == 2) {
                    list.add(new User(recordSplit[0], recordSplit[1], map.get(recordSplit[1])));
                } else {
                    list.add(new User(recordSplit[0], recordSplit[1], recordSplit[2]));
                    map.put(recordSplit[1], recordSplit[2]);
                }
            }
        }

        for (User user : list) {
            if (user.state.equals("Enter")) {
                messages.add(map.get(user.userId) + "님이 들어왔습니다.");
            } else {
                messages.add(map.get(user.userId) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            answer[i] = messages.get(i);
        }

        return answer;
    }

    static class User {
        String state;
        String userId;
        String name;

        public User(String state, String userId, String name) {
            this.state = state;
            this.userId = userId;
            this.name = name;
        }
    }
}
