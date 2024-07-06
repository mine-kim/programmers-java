package learn.challenges.exhaustivesearch;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 *
 * Time Complexity: O(n! * √n)
 * Space Complexity: O(n)
 */
public class FindingPrimeNumbers {
    private Set<Integer> primeSet = new HashSet<>();

    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited); // 모든 조합 탐색

        return primeSet.size(); // 소수 개수 반환
    }

    private void dfs(String current, String numbers, boolean[] visited) {
        if (!current.isEmpty()) {
           if(isPrime(Integer.parseInt(current))) { // 소수 판별
               primeSet.add(Integer.parseInt(current));
           }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindingPrimeNumbers solution = new FindingPrimeNumbers();
        solution.solution("171");
    }
}
