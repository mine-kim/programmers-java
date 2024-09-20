package learn.challenges.binarysearch;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * 제목: 비밀 지도
 *
 * Time Complexity:  O(m * log( n * max time)) 이분 탐색의 시간 복잡도, 각 심사대마다 계산을 하므로 한 번의 계산은 O(m)의 시간
 * Space Complexity: O(m): 배열 times를 저장하는 데 필요한 공간
 */
public class Immigration {
    public static long solution(int n, int[] times) {
        long left = 1;
        long right = Arrays.stream(times).max().getAsInt() * (long)n; // 최악의 시나리오
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (int time : times) {
                total += mid / time; // 각 심사대가 mid 시간 동안 처리할 수 있는 사람 수
            }

            if (total >= n) { // 심사할 수 있는 사람이 n명 이상이면
                answer = mid; // 시간을 줄여 더 작은 값도 가능한지 확인
                right = mid - 1;
            } else { // 부족하다면 시간을 늘려야 함
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(6, new int[]{7,10}));
    }
}
