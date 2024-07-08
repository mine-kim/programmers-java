package learn.challenges.courses.lv2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 * 제목: 짝지어 제거하기
 *
 * Time Complexity: O(n) 반복문
 * Space Complexity: O(n) stack에 모든 문자가 쌓일 수 있음
 */
public class ToRemoveByPairing {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 같은 문자 쌍 제거
            } else {
                stack.push(c); // 스택에 문자 추가
            }
        }

        return stack.isEmpty() ? 1 : 0; // 스택이 비어있으면 성공, 아니면 실패
    }

    public int solution2(String s) {
        if(s.length() < 2) return 0;
        String[] split = s.split("");
        Deque<String> stack = new LinkedList<String>();
        for (String str : split) {
            if(!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        ToRemoveByPairing solution = new ToRemoveByPairing();
        solution.solution("baabaa");
    }
}
