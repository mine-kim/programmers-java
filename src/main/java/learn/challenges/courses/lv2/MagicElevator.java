package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 제목: 마법의 엘리베이터
 *
 * Time Complexity: O(log₁₀(n)) storey의 자릿수에 비례
 * Space Complexity: O(1)
 */
public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int num = storey % 10;  // 현재 자리수
            int next = (storey / 10) % 10;  // 다음 자리수 (다음 자릿수만 미리 확인)

            if (num > 5 || (num == 5 && next >= 5)) {
                // num이 5보다 크거나, num이 5이고 다음 자리수도 5 이상이면 올림
                answer += 10 - num;
                storey = storey / 10 + 1;  // 올림 처리
            } else {
                // 그렇지 않으면 num만 더함
                answer += num;
                storey /= 10;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MagicElevator solution = new MagicElevator();
        System.out.println("solution = " + solution.solution(555));
        System.out.println("solution = " + solution.solution(99));
        System.out.println("solution = " + solution.solution(80));
        System.out.println("solution = " + solution.solution(19));
        System.out.println("solution = " + solution.solution(201));
        System.out.println("solution = " + solution.solution(2554));
        System.out.println("solution = " + solution.solution(1000000000));
    }
}
