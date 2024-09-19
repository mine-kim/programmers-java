package learn.challenges.courses.lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86051
 * 제목: 없는 숫자 더하기
 *
 * Time Complexity: O(n): n은 배열의 길이
 * Space Complexity: O(1): 상수 공간 사용
 */
public class AddNumbersNoExsist {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) {
            answer -= number;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
