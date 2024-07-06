package learn.challenges.exhaustivesearch;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 *
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */
public class Dungeons {
    int round;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; // 던전 방문 여부
        dfs(k, dungeons, visited, 0);
        return round;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        round = Math.max(count, round); // 방문 횟수가 최대인 경우

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 방문 안한 던전, 에너지가 다음 던전 방문 가능한 정도로 남아 있는지 체크
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited,  count + 1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        Dungeons solution = new Dungeons();
        solution.solution(80, new int[][]{{80,20},{50,40},{30,10}});
    }
}
