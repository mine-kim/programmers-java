package learn.challenges.dp.lv4;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42897
 * 제목: 도둑질
 *
 * Time Complexity: O(n) – 배열을 한 번 순회하면서 DP 값을 계산
 * Space Complexity: O(n) – 두 개의 DP 배열(dp1, dp2)을 사용
 */
public class Stealing {
    public int solution(int[] money) {
        int n = money.length;

        // 첫 번째 집을 털고, 마지막 집은 털지 않는 경우
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]); // 첫번째와 두번째중 더 많은 금액

        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]); // 현재 집 + 2개 전의 금액 or 1개전 금액 중에 큰값이 최대 금액
        }

        // 첫 번째 집을 털지 않고, 마지막 집을 터는 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];

        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }

        // 두 경우 중 큰 값 반환
        return Math.max(dp1[n-2], dp2[n-1]);
    }

    public static void main(String[] args) {
        Stealing solution = new Stealing();
        System.out.println(solution.solution(new int[]{1,1,4,1,4})); // 8
        System.out.println(solution.solution(new int[]{1,2,3})); // 3
        System.out.println(solution.solution(new int[]{1,1,1})); // 1
        System.out.println(solution.solution(new int[]{1,3,4,8,6,4,9,9})); // 24
        System.out.println(solution.solution(new int[]{10, 5, 3, 1, 10})); // 15
        System.out.println(solution.solution(new int[]{1,2,3,1})); // 4
        System.out.println(solution.solution(new int[]{1000,0,0,1000,0,0,1000,0,0,1000})); // 3000
        System.out.println(solution.solution(new int[]{1000,1,0,1,2,1000,0})); // 2001
        System.out.println(solution.solution(new int[]{1000,0,0,0,0,1000,0,0,0,0,0,1000})); // 2000
    }
}
