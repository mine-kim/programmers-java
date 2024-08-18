package learn.challenges.greedy.lv3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 * 제목: 단속카메라
 *
 * Time Complexity: O(n log n) 정렬과 탐색
 * Space Complexity: O(1) 추가적인 메모리 사용은 거의 없음
 *
 */
public class SurveillanceCamera {
    public int solution(int[][] routes) {
        int answer = 0;

        // 차량 경로의 끝나는 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt((int[] o) -> o[1]));

        int lastCamera = Integer.MIN_VALUE; // 마지막으로 설치된 카메라 위치를 저장

        for (int[] route : routes) {
            // 현재 차량의 시작 지점이 마지막 카메라 위치보다 뒤에 있으면 새로운 카메라 설치 필요
            if (route[0] > lastCamera) {
                lastCamera = route[1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SurveillanceCamera solution = new SurveillanceCamera();
        solution.solution(new int[][]{{-20, -15}, {-14, -5}, {-16, -11}, {-18, -13}, {-5, -3}});
    }
}
