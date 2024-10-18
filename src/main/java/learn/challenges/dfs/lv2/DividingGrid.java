package learn.challenges.bfs.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * 제목: 전력망을 둘로 나누기
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DividingGrid {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new List[n + 1]; // 그래프 표현
        int[] counts = new int[n + 1]; // 각 송전탑을 루트로 하는 서브트리의 송전탑 개수

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        dfs(1, 0, graph, counts); // 루트 노드부터 DFS 탐색

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minDiff = Math.min(minDiff, Math.abs(counts[i] - (n - counts[i]))); // 두 전력망의 송전탑 개수 차이 계산
        }

        return minDiff;
    }

    private int dfs(int current, int prev, List<Integer>[] graph, int[] counts) {
        counts[current] = 1; // 현재 노드 포함

        //자식 노드의 갯수 구하기
        for (int next : graph[current]) {
            if (next != prev) {
                counts[current] += dfs(next, current, graph, counts);
            }
        }
        return counts[current];
    }

    public static void main(String[] args) {
        /**
         *   1
         *    \
         *     3 - 2
         *      |
         *      4
         *    / | \
         *   5  6  7
         *        / \
         *       8   9
         * [9, 1, 8, 6, 1, 1, 3, 1, 1]
         */
        DividingGrid solution = new DividingGrid();
        solution.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
    }
}
