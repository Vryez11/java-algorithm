package src.programmers.lv2;

import java.util.*;

public class Problem28 {

    public int[] solution(String s) {
        String[] split = s.replaceAll("[{}]", " ").trim().split(" , ");
        List<int[]> list = new ArrayList<>();

        for (String temp : split) {
            String[] resSplit = temp.trim().split(",");
            int[] res = new int[resSplit.length];
            for (int i = 0; i < resSplit.length; i++) {
                res[i] = Integer.parseInt(resSplit[i].trim());
            }
            list.add(res);
        }

        list.sort(Comparator.comparingInt(a -> a.length));

        Set<Integer> set = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();

        for (int[] arr : list) {
            for (int num : arr) {
                if (set.add(num)) {
                    resultList.add(num);
                }
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
