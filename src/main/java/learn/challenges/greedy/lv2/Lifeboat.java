package learn.challenges.greedy.lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * 제목: 구명보트
 *
 * Time Complexity: O(n log n) 정렬
 * Space Complexity: O(log n) 정렬
 */
public class Lifeboat {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;
        while (min < max) {
            if (people[min] + people[max] > limit) {
                max--;
            } else {
                min++;
                max--;
            }
            answer++;
            if (max == min) answer++; // 마지막 사람은 혼자서 보트를 탐
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{40, 50, 60, 90}, 100));
    }
}
