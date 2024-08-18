package learn.challenges.courses.lv3;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927
 * 제목: 야근 지수
 *
 * Time Complexity: O(n log M) 힙의 삽입과 삭제
 * Space Complexity: O(M)
 *
 */
public class OvertimeIndex {
    public long solution(int n, int[] works) {
        // Max Heap 사용을 위해 Collections.reverseOrder() 사용
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // works 배열의 모든 요소를 힙에 추가
        for (int work : works) {
            maxHeap.offer(work);
        }

        // n 시간이 다 소진될 때까지 작업량이 가장 큰 일을 줄임
        while (n > 0) {
            if (maxHeap.isEmpty()) break;

            int maxWork = maxHeap.poll(); // 작업량이 가장 큰 값을 꺼냄
            if (maxWork > 0) {
                maxHeap.offer(maxWork - 1); // 1만큼 줄여서 다시 힙에 추가
            }
            n--;
        }

        // 야근 피로도를 계산
        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int remainingWork = maxHeap.poll();
            answer += (long) remainingWork * remainingWork; // 제곱하여 더함
        }

        return answer;
    }

    public static void main(String[] args) {
        OvertimeIndex solution = new OvertimeIndex();
        solution.solution(4, new int[]{4, 3, 3});
        solution.solution(1, new int[]{2, 1, 2});
        solution.solution(3, new int[]{1, 1});
    }
}
