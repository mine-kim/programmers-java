package learn.challenges.courses.lv1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * 제목: 비밀 지도
 *
 * Time Complexity: O(n log n): 배열을 정렬하는 데 O(n log n) 시간이 걸리고, 반복문을 통해 배열을 탐색하는 데 O(n) 시간
 * Space Complexity: O(1): 고정 변수 사용
 */
public class Budget {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if( budget < d[answer]) break;
            budget -= d[answer];
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new int[]{1,3,2,5,4}, 9));
        System.out.println("solution = " + solution(new int[]{2,2,3,3}, 10));
    }
}
