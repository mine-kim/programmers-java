package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * 제목: n^2 배열 자르기
 *
 * Time Complexity: O(right - left) 반복문
 * Space Complexity: O(right - left) answer 배열
 */
public class N2ArraySlice {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left)+1];

        for (long i = left; i <= right; i++) {
            long x1 = i / n;
            long x2 = i % n;
            answer[(int) (i-left)] = (int) Math.max(x1, x2) + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        N2ArraySlice solution = new N2ArraySlice();
        solution.solution(3, 2, 5);
        solution.solution(4, 7, 14);
    }
}
