package learn.challenges.bfs.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 문제: 게임 맵 최단거리
 *
 * Time Complexity: O(n * m) BFS는 각 노드를 한 번씩 탐색. n: 행 개수, m: 열 개수
 * Space Complexity: O(n * m) 큐의 최대 크기는 전체 맵의 크기와 같으므로
 *
 */
public class ShortestDistance {
    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // 목적지에 도착하면 해당 위치까지의 거리를 반환
            if (row == n - 1 && col == m - 1) {
                return maps[row][col];  // 현재 maps[row][col]은 시작점에서의 거리
            }

            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                // 이동할 좌표가 유효하고, 아직 방문하지 않은 경로인 경우
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    // 거리 갱신
                    maps[nr][nc] = maps[row][col] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}})); //expect: 11
        System.out.println("solution = " + solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}})); //expect: -1
    }
}
