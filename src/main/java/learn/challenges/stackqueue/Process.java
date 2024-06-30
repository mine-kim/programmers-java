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

        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            priorityQueue.offer(priorities[i]);
        }

        int order = 0;
        while (!queue.isEmpty()) {
            int currIndex = queue.poll(); // 0
            int currNum = priorities[currIndex]; // 1

            if (currNum == priorityQueue.peek()) {
                order++;
                priorityQueue.poll();
                if (currIndex == location) {
                    return order;
                }
            } else {
                queue.offer(currIndex);
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
