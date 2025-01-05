package src.programmers.problems;

public class Programmers10 {
    public String solution(String new_id) {
        String temp_id;

        temp_id = firstProcess(new_id);
        temp_id = secondProcess(temp_id);
        temp_id = thirdProcess(temp_id);
        temp_id = fourthProcess(temp_id);
        temp_id = fifthProcess(temp_id);
        temp_id = sixthProcess(temp_id);
        temp_id = sevnethProcess(temp_id);

        return temp_id;
    }

    private static String firstProcess(String id) {
        return id.toLowerCase();
    }
    private static String secondProcess(String id) {
        String match = "[^0-9 a-z . _ \\-]";
        return id.replaceAll(match, "");
    }
    private static String thirdProcess(String id) {
        String tmp = id.replaceAll("\\.\\.", "\\.");
        while(!tmp.equals(tmp.replaceAll("\\.\\.", "\\."))) {
            tmp = tmp.replaceAll("\\.\\.", "\\.");
        }
        return tmp;
    }
    private static String fourthProcess(String id) {
        if (id.charAt(0) == '.') {
            id = id.replaceFirst("\\.", "");
        }
        if (id.isEmpty()) return id;
        if (id.charAt(id.length()-1) == '.') {
            id = id.substring(0, id.length()-1);
        }
        return id;
    }
    private static String fifthProcess(String id) {
        id = id.replaceAll(" ", "");
        if (id.isEmpty()) id += "a";
        return id;
    }
    private static String sixthProcess(String id) {
        if (id.length() > 15) id = id.substring(0, 15);
        id = fourthProcess(id);
        return id;
    }
    private static String sevnethProcess(String id) {
        int len = id.length();
        if (len < 3) {
            while(id.length() != 3) {
                id += String.valueOf(id.charAt(id.length()-1));
            }
        }
        return id;
    }
}