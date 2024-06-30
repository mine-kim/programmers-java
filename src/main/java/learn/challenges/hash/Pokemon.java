package learn.challenges.hash;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Pokemon {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Object> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = nums.length / 2;
        if (max > set.size()) answer = set.size();
        else answer = max;

        return answer;
    }

    public static void main(String[] args) {
        Pokemon solution = new Pokemon();
        solution.solution(new int[]{3,1,2,3});
    }
}
