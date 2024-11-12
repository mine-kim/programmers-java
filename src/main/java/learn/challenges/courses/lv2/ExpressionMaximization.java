package learn.challenges.courses.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 * 제목: 수식 최대화
 *
 * Time Complexity: O(6×n^2): 가능한 연산자 우선순위 조합은 6가지이고, 각 조합에 대해 연산자를 순차적으로 찾아 제거하며 계산하므로, 연산자 수 n에 대해 최대 반복이 필요
 * Space Complexity: O(n): 각 연산자 우선순위 조합마다 숫자와 연산자 리스트를 복사해 사용하므로, 원래 표현식의 길이에 비례하는 추가 메모리가 필요
 */
public class ExpressionMaximization {
    private long answer = 0;
    Character[][] cal = {{'+', '-', '*'}, {'+', '*', '-'},
            {'-', '+', '*'}, {'-', '*', '+'},
            {'*', '-', '+'}, {'*', '+', '-'}}; // 경우의 수 6가지

    public long solution(String expression) {
        answer = 0;
        Queue<Character> operators = new LinkedList<>();
        Queue<Long> numbers = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operators.add(c);
            } else {
                sb.append(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));

        for (Character[] order : cal) {
            answer = Math.max(answer, Math.abs(evaluateExpression(new ArrayList<>(numbers), new ArrayList<>(operators), order)));
        }

        return answer;
    }

    private long evaluateExpression(List<Long> numbers, List<Character> operators, Character[] order) {

        for (char op : order) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == op) {
                    long result = applyOperation(numbers.remove(i), numbers.remove(i), op);
                    numbers.add(i, result);
                    operators.remove(i);
                    i--;
                }
            }
        }
        return numbers.get(0); // 최종 결과 반환
    }

    private long applyOperation(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    public static void main(String[] args) {
        ExpressionMaximization solution = new ExpressionMaximization();
        System.out.println("solution = " + solution.solution("100-200*300-500+20"));
        System.out.println("solution = " + solution.solution("50*6-3*2"));
    }
}
