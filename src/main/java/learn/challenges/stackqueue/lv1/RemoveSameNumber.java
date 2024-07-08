package learn.challenges.stackqueue.lv1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * 제목: 같은 숫자는 싫어
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class RemoveSameNumber {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.offer(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(deque.peekLast() != arr[i]) {
                deque.offer(arr[i]);
            }
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        RemoveSameNumber solution = new RemoveSameNumber();
        solution.solution(new int[]{4,4,3,3,3});
        solution.solution(new int[]{1,1,3,3,0,1,1});
    }
}
