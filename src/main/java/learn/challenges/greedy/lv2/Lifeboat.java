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
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 50, 50, 70, 80
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
            if (max == min) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Lifeboat solution = new Lifeboat();
        solution.solution(new int[]{70, 50, 80, 50}, 100);
    }
}
