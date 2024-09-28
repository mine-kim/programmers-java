package learn.challenges.binarysearch;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43236
 * 제목: 징검다리
 *
 * Time Complexity:  O(m * log( n * max time)) 이분 탐색의 시간 복잡도, 각 심사대마다 계산을 하므로 한 번의 계산은 O(m)의 시간
 * Space Complexity: O(m): 배열 times를 저장하는 데 필요한 공간
 */
public class SteppingStone {
    public static int solution(int distance, int[] rocks, int n) {
        long left = 0;
        long right = distance;
        long answer = 0;

        Arrays.sort(rocks);

        while(left <= right) {
            long mid = (left + right) / 2; // 지점 사이의 거리의 최솟값 중에 최대값
            int removedRocks = 0;
            int prevRock = 0;

            // 각 바위 사이의 거리 계산
            for (int rock : rocks) {
                if (rock - prevRock < mid) {
                    removedRocks++;  // 거리가 너무 짧으면 바위 제거
                } else {
                    prevRock = rock;  // 거리가 충분하면 현재 바위를 기준으로
                }
            }

            // 마지막 바위에서 종료 지점의 거리도 확인
            if (distance - prevRock < mid) {
                removedRocks++;
            }
            System.out.println("mid = " + mid + ", removedRocks = " + removedRocks + ", left ~ right (" + left + " - " + right + ")");

            // 만약 제거한 바위가 n개 이하라면, 가능한 거리를 늘림
            if (removedRocks <= n) {
                answer = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
}
