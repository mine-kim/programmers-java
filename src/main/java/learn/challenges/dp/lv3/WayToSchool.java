package learn.challenges.dp.lv3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898
 * 제목: 등굣길
 *
 * Time Complexity: O(m * n) DP 테이블의 모든 칸을 한 번씩 방문
 * Space Complexity: O(m * n)
 *
 */
public class WayToSchool {

    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;

        // DP 테이블 초기화
        int[][] dp = new int[n+1][m+1];
        dp[1][1] = 1;  // 시작점

        // 물에 잠긴 지역 표시
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;  // 물에 잠긴 지역은 경로 수 0
                } else {
                    if (i > 1) dp[i][j] += dp[i-1][j];
                    if (j > 1) dp[i][j] += dp[i][j-1];
                    dp[i][j] %= MOD;  // 1,000,000,007로 나눈 나머지
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        WayToSchool solution = new WayToSchool();
        solution.solution(4, 3, new int[][]{{2,2}});
    }
}
