package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * 제목: [3차] n진수 게임
 *
 * Time Complexity: O(t * m) t는 출력해야 할 문자열의 길이, m은 참가 인원
 * Space Complexity: O(t) StringBuilder
 */
public class BinaryGame {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int index = 1;

        loop:
        for (int i = 0; i < t * m; i++) {
            String str = Integer.toString(i, n);
            for (char c : str.toCharArray()) {
                if (index % m == p % m) answer.append(c);
                if (answer.length() == t) break loop;
                index++;
            }
        }

        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        BinaryGame solution = new BinaryGame();
        solution.solution(2,4,2,1);
        solution.solution(16,16,2,1);
        solution.solution(16,16,2,2);
    }
}
