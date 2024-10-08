package learn.challenges.dp.lv3;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 제목: 정수 삼각형
 *
 * Time Complexity: O(n^2) (삼각형의 모든 요소를 한 번씩 순회하기 때문)
 * Space Complexity: O(n^2) (DP 테이블을 저장하는 데 사용됨)
 */
public class IntegerTriangle {

    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];

        // 초기값 설정
        dp[0][0] = triangle[0][0];

        // DP로 최대값 계산
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; // 왼쪽 가장자리
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; // 오른쪽 가장자리
        }

        // 마지막 행에서 최대값 찾기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }

    /**
     * Time Complexity: O(n^2) (삼각형의 모든 요소를 한 번씩 탐색하므로)
     * Space Complexity: O(1) (삼각형 배열을 in-place로 수정하므로)
     */
    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }

    public static void main(String[] args) {
        IntegerTriangle solution = new IntegerTriangle();
        System.out.println(solution.solution2(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}
