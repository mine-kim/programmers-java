package learn.challenges.stackqueue;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class Process {
    public int solution(int[] priorities, int location) {

        Queue<Integer> queue = new LinkedList<>(); // priorities 위치 저장
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 순으로 중요도 저장

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            priorityQueue.offer(priorities[i]);
        }

        int order = 0;
        while (!queue.isEmpty()) {
            int currIndex = queue.poll(); // 가져올 위치
            int currNum = priorities[currIndex]; // 위치에 해당하는 중요도 정보

            if (currNum == priorityQueue.peek()) { // 중요도가 우선순위의 최상위 값인지 체크
                order++;
                priorityQueue.poll();
                if (currIndex == location) { // 알고싶은 프로세스의 위치일 경우 반환
                    return order;
                }
            } else {
                queue.offer(currIndex); // 프로세스를 다시 큐에 저장
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Process solution = new Process();
        solution.solution(new int[]{2, 1, 3, 2}, 2);
        solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}
