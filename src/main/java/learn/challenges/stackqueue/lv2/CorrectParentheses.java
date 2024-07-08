package learn.challenges.stackqueue.lv2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 제목: 올바른 괄호
 *
 * Time Complexity: O(n) 반복문
 * Space Complexity: O(n) 배열
 */
public class CorrectParentheses {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false; // 닫는 괄호가 먼저 나오거나 짝이 맞지 않음
                }
            }
        }

        return stack.isEmpty(); // 모든 괄호 쌍이 올바르게 닫혔는지 확인
    }

    boolean solution2(String s) {
        String[] list = s.split("");

        if(!list[0].equals("(")) return false;

        int index = 0;
        for(String str : list) {
            if(index < 0) return false;
            if (str.equals("(")) {
                ++index;
            } else if (str.equals(")")) {
                --index;
            }
        }

        return index == 0;
    }

    public static void main(String[] args) {
        CorrectParentheses solution = new CorrectParentheses();
        solution.solution("(()(");
    }
}
