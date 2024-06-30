package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class FibonacciNumber {
    public int solution(int n) {
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
