package learn.challenges;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 *
 * Time Complexity: O(N^2) 문자열 길이만큼 반복 함수 호출
 * Space Complexity: O(N) 새로운 문자열 생성, 문자열을 한번 순회하여 스택 연산
 */
public class RotateParentheses {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isCollect(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }

    private boolean isCollect(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!((top == '(' && c == ')') || (top == '[' && c == ']') || (top == '{' && c == '}'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        RotateParentheses solution = new RotateParentheses();
        solution.solution("}]()[{");
    }
}
