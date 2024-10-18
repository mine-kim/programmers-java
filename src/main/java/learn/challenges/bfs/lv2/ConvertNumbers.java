package learn.challenges.dfsnbfs.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538#
 * 제목: 숫자 변환하기
 *
 * Time Complexity: O(y) 각 상태에서 3개의 연산을 할 수 있으며, 최대 상태 수는 y
 * Space Complexity: O(y) visited 배열은 y+1 크기
 */
public class ConvertNumbers {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});

        boolean[] visited = new boolean[y + 1];
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentValue = current[0];
            int steps = current[1];

            // 현재 값이 y와 같으면 연산 횟수 반환
            if (currentValue == y) {
                return steps;
            }

            // 가능한 다음 값
            int[] nextValues = {currentValue + n, currentValue * 2, currentValue * 3};

            for (int nextValue : nextValues) {
                if (nextValue <= y && !visited[nextValue]) { // 범위 내에 있고 방문하지 않은 경우
                    visited[nextValue] = true;
                    queue.add(new int[]{nextValue, steps + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ConvertNumbers solution = new ConvertNumbers();

        // 예시 테스트
        System.out.println(solution.solution(10, 40, 5));   // 2
        System.out.println(solution.solution(10, 40, 30));  // 1
        System.out.println(solution.solution(2, 5, 4));     // -1
    }
}
