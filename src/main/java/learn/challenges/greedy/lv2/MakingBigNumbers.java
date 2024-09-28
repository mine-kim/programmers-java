package learn.challenges.greedy.lv2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * 제목: 큰 수 만들기
 *
 * Time Complexity: O(N^2) 문자열 변환 O(N), 중첩문 O(N * k) 최악의 경우 O(N^2)
 * Space Complexity: O(N) StringBuilder, 배열 사용
 */
public class MakingBigNumbers {
    public static String solution(String number, int k) {
        int[] numbers = new int[number.length()];
        for(int i = 0; i < number.length(); i++) {
            numbers[i] = Integer.parseInt(number.substring(i, i + 1));
        }

        StringBuilder answer = new StringBuilder();
        int min = 0;
        int max = k; // 첫번째 숫자
        while (answer.length() != number.length() - k) {
            int fix = numbers[min];
            for (int i = min; i <= max; i++) {
                if (fix < numbers[i]) {
                    fix = Math.max(fix, numbers[i]);
                    min += i - min;
                }

            }
            answer.append(fix);
            min++;
            max++;
        }

        return answer.toString();
    }

    /**
     * Time Complexity: O(N) N은 입력 문자열 number의 길이
     * Space Complexity: O(N) StringBuilder, Stack 사용
     */
    public static String solution2(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int removed = 0; // 제거 횟수

        for (char num : number.toCharArray()) {
            while (!stack.isEmpty() && removed < k && stack.peek() < num) {
                stack.pop();
                removed++;
            }
            stack.push(num);
        }

        // k개를 모두 제거하지 못한 경우, Stack 뒤쪽에서 제거
        while (removed < k) {
            stack.pop();
            removed++;
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        return answer.reverse().toString(); // Stack에서 꺼낸 순서 반대로
    }

    public static void main(String[] args) {
        //System.out.println("solution = " + solution2("9876543214", 4));
        System.out.println("solution = " + solution2("333222111", 2));
        System.out.println("solution = " + solution2("1924", 2));
        System.out.println("solution = " + solution2("1231234", 3));
        System.out.println("solution = " + solution2("4177252841", 4));
    }
}
