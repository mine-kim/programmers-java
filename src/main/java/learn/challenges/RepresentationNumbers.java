package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 *
 * Time Complexity: O(√n)
 * Space Complexity:  O(n)
 */
public class RepresentationNumbers {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) { // i는 연속된 자연수의 개수
            if (n % i == 0) {
                int consecutiveSum = i * (i - 1) / 2; // 연속된 i개의 자연수 합
                if ((n - consecutiveSum) % i == 0) { // 나머지가 i로 나누어 떨어지면 가능
                    answer++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        RepresentationNumbers solution = new RepresentationNumbers();
        solution.solution(15);
    }
}
