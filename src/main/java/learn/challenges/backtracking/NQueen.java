package learn.challenges.backtracking;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 * 제목: N-Queen
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 */
public class NQueen {
    static int answer = 0;
    public static int solution(int n) {
        answer = 0;
        int[] queens = new int[n]; // row별 col 위치
        backtrack(n, 0, queens);
        return answer;
    }

    private static void backtrack(int n, int row, int[] queens) {
        if (row == n) {
            answer++;  // 모든 퀸을 성공적으로 배치했을 경우 카운트 증가
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                System.out.println("row = " + row + ", col = " + col);
                queens[row] = col;  // 퀸을 해당 열에 배치
                backtrack(n, row + 1, queens);  // 다음 행으로 이동
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 있는지 또는 대각선에 있는지 체크
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;  // 같은 열 또는 대각선에 퀸이 있는 경우 안전하지 않음
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("solution(4) = " + solution(4));
    }
}
