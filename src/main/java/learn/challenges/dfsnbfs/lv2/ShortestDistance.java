package learn.challenges.dfsnbfs.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 문제: 게임 맵 최단거리
 *
 * Time Complexity: O(n * m) n: 행 개수, m: 열 개수
 * Space Complexity: O(n * m) 최악의 경우 모두 큐에 들어감
 *
 */
public class ShortestDistance {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 좌표, 거리 저장
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int dist = current[2]; // 현재까지의 거리

            if (row == n - 1 && col == m - 1) {
                return dist; // 목표 지점 도착 시 거리 반환
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dx[i];
                int nc = col + dy[i];

                // 범위 체크와 방문 여부 확인을 먼저 수행
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestDistance solution = new ShortestDistance();
        solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}); //expect: 11
        solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}); //expect: -1
    }
}
