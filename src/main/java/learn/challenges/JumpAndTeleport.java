package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 *
 * Time Complexity: O(log n) 각 반복에서 n은 절반 또는 -1
 * Space Complexity: O(1) 변수 2개 사용
 */
public class JumpAndTeleport {

    public int solution(int n) {
        int count = 1;
        if (n == 1) return 1;
        while(n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n--;
                count++;
            }
        }
        return count;
    }
    // 6
    // j1, t2, t4, j5, j6
    // j1, t2, j3, t6

    public static void main(String[] args) {
        JumpAndTeleport solution = new JumpAndTeleport();
        solution.solution(5000);
    }
}
