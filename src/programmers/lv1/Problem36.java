package src.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;

public class Problem36 {

    private HashMap<Integer, String> myMap;
    private int n;

    public String[] solution(String[] strings, int n) {

        myMap = new HashMap<>();
        this.n = n;
        for (int i = 1; i <= strings.length; i++) {
            myMap.put(i, strings[i - 1]);
        }

        mergeSort(1, strings.length);
        for (int i = 1; i <= strings.length; i++) {
            strings[i - 1] = myMap.get(i);
        }
        System.out.println(Arrays.toString(strings));

        return strings;
    }

    private void mergeSort(int start, int end) {
        if (end - start < 1) return;
        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        HashMap<Integer, String> tempMap = new HashMap<>();
        for (int i = start; i <= end; i++) {
            tempMap.put(i, myMap.get(i));
        }
        int k = start;
        int index1 = start, index2 = mid + 1;

        while (index1 <= mid && index2 <= end) {
            if (tempMap.get(index2).charAt(n) < tempMap.get(index1).charAt(n)) {
                myMap.put(k, tempMap.get(index2));
                index2++;
                k++;
            } else if (tempMap.get(index2).charAt(n) > tempMap.get(index1).charAt(n)) {
                myMap.put(k, tempMap.get(index1));
                index1++;
                k++;
            } else {
                if (tempMap.get(index1).compareTo(tempMap.get(index2)) < 0) {
                    myMap.put(k, tempMap.get(index1));
                    index1++;
                    k++;
                } else {
                    myMap.put(k, tempMap.get(index2));
                    index2++;
                    k++;
                }
            }
        }
        while (index1 <= mid) {
            myMap.put(k, tempMap.get(index1));
            index1++;
            k++;
        }
        while (index2 <= end) {
            myMap.put(k, tempMap.get(index2));
            index2++;
            k++;
        }
    }

}
