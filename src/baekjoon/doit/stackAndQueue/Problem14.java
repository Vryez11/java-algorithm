package src.baekjoon.doit.stackAndQueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem14 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // PriorityQueue 제작
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            // x, y의 비교 우선순위 설정
            // x에게 높은 우선순위를 주고 싶으면 음수값 return

            // 두개의 수 절대 값
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            // 두 값이 같을 경우
            if(absX == absY) {
                // x가 y보다 작거나 같을 경우 : x가 음수 or x,y 같은 값
                if(x<=y)
                    return -1; // +x에게 높은 우선순위를
                else
                    return 1; // y에게 높은 우선순위를
            }

            // x가 y보다 작은 절대값 수일 경우
            else if(absX < absY)
                return -1;  // x에게 높은 우선순위를

                // x가 y보다 큰 절대값 수일 경우
            else
                return 1; // y에게 높은 우선순위를
        });

        // 배열 입력 받으면서 동시에 Queue 작업 시작
        for(int i=0;i<N;i++) {
            // num 입력 받기
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            // num == 0 : 절대값 가장 작은 수 꺼내기
            if(num == 0) {
                // queue가 비워있으면 0 출력
                if(queue.isEmpty())
                    bw.write("0\n");
                    // queue에 값이 존재하면 맨 위에 값 출력
                else
                    bw.write(queue.poll()+"\n");
            }

            //  num != 0 : queue에 값 넣기
            else {
                queue.add(num);
            }
        }
        bw.flush();
        bw.close();
    }
}