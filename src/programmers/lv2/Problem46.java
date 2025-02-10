package src.programmers.lv2;

import java.util.*;

class Problem46 {

    // 주차 요금 계산
    public int[] solution(int[] fees, String[] records) {
        // 요금표 정보
        int baseTime = fees[0];   // 기본 시간 (분)
        int baseFee = fees[1];    // 기본 요금 (원)
        int unitTime = fees[2];   // 단위 시간 (분)
        int unitFee = fees[3];    // 단위 요금 (원)

        Map<String, Integer> inTime = new HashMap<>();  // 입차 시간 기록
        Map<String, Integer> parkingTime = new HashMap<>();  // 누적 주차 시간 기록

        // 입/출차 기록 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            String timeStr = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            int time = toMinutes(timeStr);  // HH:MM을 분으로 변환

            if (action.equals("IN")) {
                inTime.put(carNumber, time);  // 입차 기록 저장
            } else {
                int inTimeValue = inTime.remove(carNumber);
                int parkedTime = time - inTimeValue; // 주차 시간 계산
                parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedTime);
            }
        }

        // 출차되지 않은 차량은 23:59(1439분) 출차로 간주
        int lastTime = toMinutes("23:59");
        for (String carNumber : inTime.keySet()) {
            int parkedTime = lastTime - inTime.get(carNumber);
            parkingTime.put(carNumber, parkingTime.getOrDefault(carNumber, 0) + parkedTime);
        }

        // 차량 번호 오름차순 정렬 후 요금 계산
        List<String> sortedCars = new ArrayList<>(parkingTime.keySet());
        Collections.sort(sortedCars);

        int[] answer = new int[sortedCars.size()];
        for (int i = 0; i < sortedCars.size(); i++) {
            String carNumber = sortedCars.get(i);
            int totalTime = parkingTime.get(carNumber);
            answer[i] = calculateFee(totalTime, baseTime, baseFee, unitTime, unitFee);
        }

        return answer;
    }

    // HH:MM 문자열을 분(min)으로 변환하는 함수
    private int toMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // 주차 요금 계산 함수
    private int calculateFee(int totalTime, int baseTime, int baseFee, int unitTime, int unitFee) {
        if (totalTime <= baseTime) {
            return baseFee;
        } else {
            int extraTime = totalTime - baseTime;
            int extraUnits = (int) Math.ceil((double) extraTime / unitTime);  // 올림 처리
            return baseFee + (extraUnits * unitFee);
        }
    }
}
