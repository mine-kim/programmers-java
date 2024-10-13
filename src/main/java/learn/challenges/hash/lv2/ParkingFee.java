package learn.challenges.hash.lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 제목: 주차 요금 계산
 *
 * Time Complexity: O(n * log n) — n은 records의 길이, records를 한 번 순회하는 데 O(n) 시간이 걸리고, 차량 번호를 정렬하는 데 O(n * log n)
 * Space Complexity: O(n) — n개의 기록에 대해 두 개의 HashMap을 사용
 */
public class ParkingFee {
    public int[] solution(int[] fees, String[] records) {
        // 차량 번호별 총 주차 시간 및 마지막 입차 시간 관리
        HashMap<String, Integer> totalTimeMap = new HashMap<>();
        HashMap<String, Integer> inTimeMap = new HashMap<>();

        // 차량별 입차 시간
        for (String record : records) {
            String[] info = record.split(" ");
            String carNumber = info[1];
            String[] time = info[0].split(":");
            int minutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            if (info[2].equals("IN")) {
                inTimeMap.put(carNumber, minutes); // 입차 시간 기록
            } else {
                int inTime = inTimeMap.remove(carNumber); // 출차 시 입차 시간 삭제
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + (minutes - inTime));
            }
        }

        // 출차 기록 없는 차량 처리 (23:59에 출차 처리)
        for (String carNumber : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNumber);
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + (23 * 60 + 59 - inTime));
        }

        // 차량 번호 오름차순 정렬
        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);

        // 결과 계산
        int[] result = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = totalTimeMap.get(carNumber);

            // 요금 계산
            int fee = fees[1]; // 기본 요금
            if (totalTime > fees[0]) {
                fee += (int) (Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3]);
            }
            result[i] = fee;
        }

        return result;
    }

    public static void main(String[] args) {
        ParkingFee solution = new ParkingFee();
        System.out.println("solution.solution() = " + Arrays.toString(solution.solution(
                new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
        )));
    }
}
