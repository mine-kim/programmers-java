package learn.challenges.stackqueue;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class FunctionDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> days = new ArrayDeque<Integer>();
        List<Integer> deploy = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            days.offer(day);
        }

        int max = 0;
        while (!days.isEmpty()) {
            int curr = days.poll();
            if (curr > max) {
                deploy.add(1);
                max = curr;
            } else {
                deploy.set(deploy.size() - 1, deploy.get(deploy.size() - 1) + 1);
            }
        }

        return  deploy.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        FunctionDevelopment solution = new FunctionDevelopment();
        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }
}
