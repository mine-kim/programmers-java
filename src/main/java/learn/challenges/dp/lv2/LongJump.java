package learn.challenges.dp.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 * 제목: 멀리 뛰기
 *
 * Time Complexity: O(n) n번 반복
 * Space Complexity: O(n) 배열의 크기
 */
public class LongJump {
    long answer = 0;
    public long solution(int n) {
        long[] dp = new long[n + 1]; // dp[i]: i개의 칸을 뛰는 방법의 수
        dp[0] = 1; // 초기값 설정
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567; // 피보나치
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LongJump solution = new LongJump();
        solution.solution(4);
    }
}
