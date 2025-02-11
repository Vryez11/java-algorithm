package src.baekjoon.level.thirteenth;

import java.io.*;
import java.util.Arrays;

public class Baekjoon97 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        radixSort(A);

        for (int num : A) {
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void radixSort(int[] arr) {
        int maxNum = Arrays.stream(arr).max().getAsInt(); // 최대값 구하기
        int maxDigit = (int) Math.log10(maxNum) + 1; // 최대 자리수 계산

        int[] output = new int[arr.length]; // 정렬 결과를 저장할 배열
        int[] count = new int[10]; // 각 자리수(0~9)의 개수를 저장할 배열

        int jarisu = 1; // 현재 처리 중인 자리수 (1의 자리부터 시작)

        for (int d = 0; d < maxDigit; d++) {
            Arrays.fill(count, 0); // count 배열 초기화

            // 각 숫자의 자리수를 기준으로 개수 카운트
            for (int num : arr) {
                int digit = (num / jarisu) % 10;
                count[digit]++;
            }

            // 누적 합 계산 (누적 합을 사용하여 출력 배열의 인덱스 결정)
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // 현재 자리수를 기준으로 데이터를 정렬하여 출력 배열에 저장
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / jarisu) % 10;
                output[--count[digit]] = arr[i];
            }

            // 정렬된 데이터를 원래 배열로 복사
            System.arraycopy(output, 0, arr, 0, arr.length);

            // 다음 자리수로 이동
            jarisu *= 10;
        }
    }
}
