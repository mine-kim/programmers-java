package learn.challenges.exhaustivesearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 *
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 */
public class Dungeons {
    int sum;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return sum;
    }

    private void dfs(int k, int[][] dungeons,  boolean[] visited, int count) {
        sum = Math.max(count, sum);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
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
