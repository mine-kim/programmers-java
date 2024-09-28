package learn.challenges.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * 제목: 할인 행사
 *
 * Time Complexity: O(N * M) discount 배열의 길이를 N, want 배열의 길이를 M이라고 할 때, 슬라이딩 윈도우는 최대 N-9번 이동
 * Space Complexity: O(M) 두 개의 맵 사용
 */
public class DiscountEvent {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 원하는 상품과 수량을 저장할 맵 생성
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 슬라이딩 윈도우 탐색
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> currentWindow = new HashMap<>();

            // 현재 10일 윈도우를 채움
            for (int j = i; j < i + 10; j++) {
                currentWindow.put(discount[j], currentWindow.getOrDefault(discount[j], 0) + 1);
            }

            // 윈도우가 원하는 항목과 일치하는지 확인
            if (currentWindow.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * Time Complexity: O(N * M) discount 배열의 길이를 N, want 배열의 길이를 M이라고 할 때, 슬라이딩 윈도우는 최대 N-9번 이동
     * Space Complexity: O(1) 배열의 크기는 최대 10
     */
    public static int solution2(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            int[] tempNumber = number.clone();

            // 시작 지점부터 전체 물품 구매
            for (int j = i; j < i + 10; j++) {
                for (int k = 0; k < want.length; k++) {
                    if (discount[j].equals(want[k])) {
                        tempNumber[k]--;
                        break;
                    }
                }
            }

            // 전체 할인받아 구매했는지 확인
            boolean allZero = true;
            for (int count : tempNumber) {
                if (count > 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
}