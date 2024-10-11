package learn.challenges.bruteforce.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 * 제목: 숫자의 표현
 *
 * Time Complexity: O(√n)
 * Space Complexity:  O(n)
 */
public class RepresentationNumbers {
    public int solution(int n) {
        int answer = 0;
        // 연속된 자연수의 합 공식 Sk = kx + k(k−1)/2
        // S1 = 1x + 1 * (1 - 1) / 2, x = 15
        // S2 = 2x + 2 * (2 - 1) / 2, x = 7 (7, 8)
        // S3 = 3x + 3 * (3 - 1) / 2, x = 4 (4, 5, 6)
        // S5 = 5x + 5 * (5 - 1) / 2, x = 1 (1, 2, 3, 4, 5)

        // 연속된 자연수의 합보다 자연수 n이 크거나 같아야 함
        for (int k = 1; k * (k + 1) / 2 <= n; k++) {
            System.out.println("k = " + k);
            if ((n - k * (k - 1) / 2) % k == 0) {
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        RepresentationNumbers solution = new RepresentationNumbers();
        solution.solution(15);
    }
}
