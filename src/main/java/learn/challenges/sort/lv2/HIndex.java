package learn.challenges.sort.lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * 제목: H-Index
 *
 * Time Complexity: O(n log n) 정렬
 * Space Complexity: O(1) 문제의 크기가 1,000 이하로 제한되어 있으므로 상수 공간으로 간주
 */
public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 현재 논문 수에서 i를 뺀 값을 H-Index 후보로 설정
            if (citations[i] >= h) {
                return h; // H-Index 조건 만족
            }
        }

        return 0; // H-Index가 0인 경우
    }

    public static void main(String[] args) {
        HIndex solution = new HIndex();
        solution.solution(new int[]{3});
        solution.solution(new int[]{3, 0, 6, 1, 5});
        solution.solution(new int[]{5, 6, 7, 8, 9});
    }
}
