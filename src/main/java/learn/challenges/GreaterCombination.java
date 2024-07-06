package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181939
 *
 * Time Complexity: O(N) 문자열 연결 연산, 문자열 정수 변환
 * Space Complexity: O(N) 문자열 연결 연산에서 임시 문자열 객체 생성
 */
public class GreaterCombination {
    public int solution(int a, int b) {
        int answer = 0;

        int sumAB = Integer.parseInt("" + a + b);
        int sumBA = Integer.parseInt("" + b + a);

        answer = sumAB >= sumBA ? sumAB : sumBA;

        return answer;
    }

    public static void main(String[] args) {
        GreaterCombination solution = new GreaterCombination();
        solution.solution(9992, 9999);
    }
}
