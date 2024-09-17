package learn.challenges.dp.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 * 제목: 피보나치 수
 *
 * Time Complexity: O(n) 배열 생성, 반복문
 * Space Complexity: O(n) 배열
 */
public class FibonacciNumber {
    public int solution(int n) {
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1234567;
            a = b;
            b = c;
        }
        return b;
    }

    public int solution2(int n) {
        int answer = 0;
        int[] data = new int[n+1];
        data[0] = 0;
        data[1] = 1;
        for (int i = 2; i <= n; i++) {
            data[i] = (data[i-1] + data[i-2])  % 1234567;
        }
        answer = data[n];
        return answer;
    }

    public static void main(String[] args) {
        FibonacciNumber solution = new FibonacciNumber();
        solution.solution(3);
    }
}
