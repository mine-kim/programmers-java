package learn.challenges.dfs.lv3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * 제목: 네트워크
 *
 * Time Complexity: O(n^2) 각 컴퓨터에 대해 n개의 연결을 확인
 * Space Complexity: O(n) visited 배열, 재귀호출 스택
 *
 */
public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않은 컴퓨터 발견
                dfs(i, computers, visited); // 연결된 모든 컴퓨터 방문
                answer++; // 네트워크 개수 증가
            }
        }
        return answer;
    }

    private void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true; // 현재 컴퓨터 방문 표시

        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) { // 연결되어 있고 방문하지 않은 컴퓨터
                dfs(i, computers, visited); // 연결된 컴퓨터 방문 (재귀)
            }
        }
    }

    public static void main(String[] args) {
        Network solution = new Network();
        solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}
