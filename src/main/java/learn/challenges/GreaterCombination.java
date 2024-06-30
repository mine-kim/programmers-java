package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/181939
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
        solution.solution(9999, 9999);
    }
}
