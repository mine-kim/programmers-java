package learn.challenges.eratosthenes;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * 제목: 소수 찾기
 *
 * Time Complexity: O(n log log n)
 * Space Complexity: O(n)
 */
public class FindingPrimeNunbers {
    public int solution(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // 소수의 배수 제거
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindingPrimeNunbers solution = new FindingPrimeNunbers();
        System.out.println("solution = " + solution.solution(10));
        System.out.println("solution = " + solution.solution(5));
        System.out.println("solution = " + solution.solution(100));
    }
}
