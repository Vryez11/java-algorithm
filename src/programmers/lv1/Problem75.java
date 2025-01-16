package src.programmers.lv1;

public class Programmers12 {
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int count = 0;
        int idx = 0;

        DataMem[] datas = new DataMem[data.length];

        for (int i = 0; i < data.length; i++) {
            datas[i] = new DataMem(data[i]);
            if (datas[i].dataProcess(ext, val_ext)) count++;
        }
        int[][] answer = new int [count][4];

        for (int j = 0; j < datas.length; j++){
            if (datas[j].dataProcess(ext, val_ext)) {
                answer[idx] = data[j];
                idx++;
            }
        }

        arraySort(answer, sort_by);

        return answer;
    }

    static void arraySort(int[][] arr, String sort_by){
        switch (sort_by) {
            case "code" -> {
                for (int j = 0; j < arr.length; j++) {
                    int minIdx = j;
                    for (int i = j; i < arr.length; i++) {
                        if (arr[i][0] < arr[minIdx][0]) minIdx = i;
                    }
                    if (minIdx == j) continue;
                    else {
                        int[] temp = arr[j];
                        arr[j] = arr[minIdx];
                        arr[minIdx] = temp;
                    }
                }
            }
            case "date" -> {
                for (int j = 0; j < arr.length; j++) {
                    int minIdx = j;
                    for (int i = j; i < arr.length; i++) {
                        if (arr[i][1] < arr[minIdx][1]) minIdx = i;
                    }
                    if (minIdx == j) continue;
                    else {
                        int[] temp = arr[j];
                        arr[j] = arr[minIdx];
                        arr[minIdx] = temp;
                    }
                }
            }
            case "maximum" -> {
                for (int j = 0; j < arr.length; j++) {
                    int minIdx = j;
                    for (int i = j; i < arr.length; i++) {
                        if (arr[i][2] < arr[minIdx][2]) minIdx = i;
                    }
                    if (minIdx == j) continue;
                    else {
                        int[] temp = arr[j];
                        arr[j] = arr[minIdx];
                        arr[minIdx] = temp;
                    }
                }
            }
            default -> {
                for (int j = 0; j < arr.length; j++) {
                    int minIdx = j;
                    for (int i = j; i < arr.length; i++) {
                        if (arr[i][3] < arr[minIdx][3]) minIdx = i;
                    }
                    if (minIdx == j) continue;
                    else {
                        int[] temp = arr[j];
                        arr[j] = arr[minIdx];
                        arr[minIdx] = temp;
                    }
                }
            }
        }
    }
}

class DataMem {
    int code;
    int date;
    int maximum;
    int remain;
    private String[] exts = {"code", "date", "maximum", "remain"};

    DataMem(int[] data) {
        code = data[0];
        date = data[1];
        maximum = data[2];
        remain = data[3];
    }

    public boolean dataProcess(String ext, int val_ext) {
        if (exts[0].equals(ext)) return code < val_ext;
        else if (exts[1].equals(ext)) return date < val_ext;
        else if (exts[2].equals(ext)) return maximum < val_ext;
        else return remain < val_ext;
    }
}