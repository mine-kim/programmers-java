package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899
 * 제목: 124 나라의 숫자
 *
 * Time Complexity: O(log₃(n)) StringBuilder 사용으로 메모리 효율성 개선
 * Space Complexity: O(log₃(n))
 */
public class Numbers124 {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n > 0) {
            int small = n % 3;
            if (small == 0) {
                answer.append("4");
                n = n / 3 - 1;
            } else {
                answer.append(small);
                n = n / 3;
            }
        }

        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        Numbers124 solution = new Numbers124();
        System.out.println("solution.solution(1) = " + solution.solution(1));
        System.out.println("solution.solution(1) = " + solution.solution(2));
        System.out.println("solution.solution(1) = " + solution.solution(4));
        System.out.println("solution.solution(1) = " + solution.solution(11));
    }
}
