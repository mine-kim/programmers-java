package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 * 제목: N개의 최소공배수
 *
 * Time Complexity: O(n) O(n log(max(arr))) 솔루션 배열 n, 최악의 경우 모든 요소가 서로소
 * Space Complexity: O(log(min(a, b)))  재귀 호출 gcd 함수
 */

public class LeastCommonMultiple {

    public int solution(int[] arr) {
        int answer = arr[0]; // 첫 번째 값으로 초기화

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]); // 최소공배수 계산
        }

        return answer;
    }

    // 최대공약수 (Greatest Common Divisor) 계산 함수
    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수 (Least Common Multiple) 계산 함수
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        LeastCommonMultiple solution = new LeastCommonMultiple();
        solution.solution(new int[]{2,6,8,14});
    }
}
