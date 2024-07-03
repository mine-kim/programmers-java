package learn.challenges.dfsnbfs;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * Time Complexity: O(2^n) DFS 탐색
 * Space Complexity: O(n) DFS에서 최대깊이까지 재귀 호출이 발생하며 numbers의 길이 n
 *
 */
public class TargetNumber {

    int answer = 0;
    int target = 0;
    public int solution(int[] numbers, int target) {
        this.target = target;
        dfs(numbers, 0, 0);
        return answer;
    }

    private void dfs(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        int next = index + 1;
        dfs(numbers, next, sum + numbers[index]);
        dfs(numbers, next, sum - numbers[index]);
    }

    public static void main(String[] args) {
        TargetNumber solution = new TargetNumber();
        solution.solution(new int[]{1, 1, 1, 1, 1}, 3);
        solution.solution(new int[]{4, 1, 2, 1}, 4);
    }
}
