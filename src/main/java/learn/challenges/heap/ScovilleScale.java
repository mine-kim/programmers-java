package learn.challenges.heap;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 *
 * Time Complexity: O(n log n) 우선순위 큐
 * Space Complexity:  O(n) 고정 크기의 배열 및 상수 사용
 */
public class ScovilleScale {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : scoville) priorityQueue.offer(i);

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) return -1; // 스코빌 지수를 만들 수 없는 경우
            int row = priorityQueue.poll(); // 가장 맵지 않은 음식
            int high = priorityQueue.poll(); // 2번째로 맵지 않은 음식
            priorityQueue.offer(row + high * 2);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ScovilleScale solution = new ScovilleScale();
        solution.solution(new int[]{1, 2}, 6);
        solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 200);
    }
}
