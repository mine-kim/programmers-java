package learn.challenges.hash;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * Time Complexity: O(n) nums 배열을 한 번 순회
 * Space Complexity: O(n) set에 최대 N개의 요소가 저장
 */
public class Pokemon {
    public int solution(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for(int num : nums) {
            set.add(num); // 중복 제거하며 종류 수 계산
        }
        return Math.min(set.size(), nums.length / 2); // 종류 수와 선택 가능한 폰켓몬 수 중 작은 값 반환
    }

    public static void main(String[] args) {
        Pokemon solution = new Pokemon();
        solution.solution(new int[]{3,1,2,3});
    }
}
