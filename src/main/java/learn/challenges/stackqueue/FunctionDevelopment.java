package learn.challenges.stackqueue;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 *
 * Time Complexity: O(n) 큐
 * Space Complexity: O(n) 큐, 배열
 */
public class FunctionDevelopment {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> days = new ArrayDeque<Integer>();
        List<Integer> deploy = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]); // 각 기능의 남은 작업 일수 계산하여 큐에 저장
            days.offer(day);
        }

        int max = 0;
        while (!days.isEmpty()) {
            int curr = days.poll(); // 현재 기능의 남은 작업 일수
            if (curr > max) {  // 현재 기능이 이전 기능보다 오래 걸리는 경우
                max = curr; // 최대 작업 일수 갱신
                deploy.add(1);
            } else {
                deploy.set(deploy.size() - 1, deploy.get(deploy.size() - 1) + 1); // 배포
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
