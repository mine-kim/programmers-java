package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 *
 * Time Complexity: O(1) n과 다음 숫자가 평균적으로 큰 차이가 없으므로.
 * Space Complexity: O(1) 변수 2개 사용
 */
public class NextBigNumber {
    public int solution(int n) {
        int count = 0;
        int countN =  Integer.bitCount(n);

        while(count != countN) {
            count = Integer.bitCount(++n);
        }
        return n;
    }

    public static void main(String[] args) {
        NextBigNumber solution = new NextBigNumber();
        solution.solution(78);
    }
}
