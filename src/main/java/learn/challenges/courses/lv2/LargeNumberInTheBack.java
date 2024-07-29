package learn.challenges.courses.lv2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * 제목: 뒤에 있는 큰 수 찾기
 *
 * Time Complexity: O(n) = 반복문 O(n) + 스택 연산의 최대 2n번
 * Space Complexity: O(n) answer 배열, 스택
 */
public class LargeNumberInTheBack {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            // 현재 숫자보다 작거나 같은 숫자들을 스택에서 꺼내면서 정답 갱신
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                int a = stack.peek();
                int b = numbers[stack.peek()];
                int c = numbers[i];
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        // 처리되지 않은 값들은 answer 값을 -1로 설정
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        LargeNumberInTheBack solution = new LargeNumberInTheBack();
        solution.solution(new int[]{2, 3, 3, 5});
        solution.solution(new int[]{9, 1, 5, 3, 6, 2});
    }
}
