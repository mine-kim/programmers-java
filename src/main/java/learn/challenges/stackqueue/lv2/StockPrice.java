package learn.challenges.stackqueue.lv2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42584
 * 제목: 주식 가격
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class StockPrice {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>(); // 인덱스 저장

        for (int i = 0; i < len; i++) {
            // 주식 가격이 떨어지면 순회
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 지금까지의 시간을 계산
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        // 떨어지지 않은 가격의 시간을 계산
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = len - 1 - idx;
        }

        return answer;
    }


    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (cur > prices[j]) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice solution = new StockPrice();
        solution.solution(new int[]{1, 2, 3, 2, 3});
        solution.solution(new int[]{2, 3, 2, 1, 3, 4, 2}); // 3, 1, 1, 3, 2, 1, 0
    }
}
