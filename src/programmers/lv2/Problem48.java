package src.programmers.lv2;

import java.util.PriorityQueue;

public class Problem48 {

    // [3차] 파일명 정렬
    public String[] solution(String[] files) {
        PriorityQueue<FileName> pq = new PriorityQueue<>();

        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            char[] chars = file.toCharArray();
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int numberStartIndex = 0;

            for (int j = 0; j < chars.length; j++) {
                char c = chars[j];
                if (c < '0' || c > '9') {
                    head.append(c);
                } else {
                    numberStartIndex = j;
                    break;
                }
            }
            for (int k = numberStartIndex; k < chars.length; k++) {
                char c = chars[k];
                if (c >= '0' && c <= '9') {
                    number.append(c);
                } else {
                    break;
                }
            }
            pq.add(new FileName(head.toString().toLowerCase(), number.toString(), file, i));
        }

        String[] answer = new String[pq.size()];
        for (int i = 0 ; i < answer.length ; i++) {
            answer[i] = pq.poll().fileName;
        }
        return answer;
    }

    static class FileName implements Comparable<FileName> {
        String head;
        String number;
        String fileName;
        int index;

        public FileName(String head, String number, String fileName, int index) {
            this.head = head;
            this.number = number;
            this.fileName = fileName;
            this.index = index;
        }

        @Override
        public int compareTo(FileName o) {
            if (!this.head.equals(o.head))
                return this.head.compareTo(o.head);
            else if (Integer.parseInt(this.number) != Integer.parseInt(o.number))
                return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
            else
                return Integer.compare(this.index, o.index);
        }
    }
}
