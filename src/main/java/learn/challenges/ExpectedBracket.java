package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 *
 * Time Complexity: O(logN) 매 라운드 참가자수가 절반
 * Space Complexity: O(1)
 */
public class ExpectedBracket {
    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            a = (a + 1) / 2; // 다음 라운드 번호 계산
            b = (b + 1) / 2;
            round++;
        }
        return round;
    }

    public static void main(String[] args) {
        ExpectedBracket solution = new ExpectedBracket();
        solution.solution(8, 4, 7);
    }
}
