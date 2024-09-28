package learn.challenges.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 제목: 연속 부분 수열 합의 개수
 *
 * Time Complexity: O(N^2) 이중 반복문
 * Space Complexity: O(N^2) 최악의 경우(모든 부분합이 다를 경우)
 */
public class SumConsecutiveSequences {
    public static int solution(int[] elements) {
        int n = elements.length;
        HashSet<Integer> sums = new HashSet<>();

        // 슬라이딩 윈도우를 이용한 부분합 계산
        for (int length = 1; length <= n; length++) {
            int windowSum = 0;

            // 초기 윈도우 설정
            for (int i = 0; i < length; i++) {
                windowSum += elements[i];
            }
            sums.add(windowSum);

            // 슬라이딩 윈도우를 사용해 다음 부분합 계산
            for (int start = 1; start < n; start++) {
                windowSum = windowSum - elements[start - 1] + elements[(start + length - 1) % n];
                sums.add(windowSum);
            }
        }

        return sums.size();
    }

    /**
     * Time Complexity: O(N^2) 이중 반복문
     * Space Complexity: O(N^2) 최악의 경우(모든 부분합이 다를 경우)
     */
    public static int solution2(int[] elements) {
        int n = elements.length;
        HashSet<Integer> sums = new HashSet<>(); // 중복 제거를 위한 HashSet

        // 모든 시작점과 길이에 대한 부분 합 계산
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int length = 1; length <= n; length++) {
                sum = (sum + elements[(start + length - 1) % n]);
                sums.add(sum);
            }
        }

        return sums.size(); // 중복 제거된 부분 합 개수 반환
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new int[]{7,9,1,1,4}));
    }
}
