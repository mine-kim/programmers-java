package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * 제목: k진수에서 소수 개수 구하기
 *
 * Time Complexity: O(n√prime) prime은 각 부분 문자열을 숫자로 변환한 값
 * Space Complexity: O(log_k(n)) k진수로 변환된 문자열의 길이에 비례
 */
public class PrimeNumber {
    public int solution(int n, int k) {
        int answer = 0;
        String prime = Integer.toString(n, k);
        String[] list = prime.split("0");
        for (String str : list) {
            if (str.isEmpty()) continue;
            long num = Long.parseLong(str);
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    private boolean isPrime(long prime) {
        if (prime == 1) return false;
        for(long i = 2; i < Math.sqrt(prime); i++) {
            if (prime % i == 0) return false;
        }
        return true;
    }
    private boolean isPrime2(long prime) {
        if (prime == 1) return false;
        if (prime % 2 == 0 || prime % 3 == 0) return true;

        for(long i = 2; i < Math.sqrt(prime); i++) {
            if (prime % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumber solution = new PrimeNumber();
        solution.solution(437674, 3);
        solution.solution(110011, 10);
        solution.solution(2468791, 7);
    }
}
