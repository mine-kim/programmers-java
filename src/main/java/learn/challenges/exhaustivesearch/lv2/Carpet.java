package learn.challenges.exhaustivesearch.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * 제목: 카펫
 *
 * Time Complexity: O(√(brown + yellow))
 * Space Complexity: O(1)
 */
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int x = 3; x < Math.sqrt(brown + yellow); x++) {
            int y = (brown - x * 2 + 4) / 2; // brown = 전체 둘레의 길이이므로, 2x + 2y - 4
            if (x * y == brown + yellow) { // 두수의 곱
                answer[0] = Math.max(x ,y);
                answer[1] = Math.min(x, y);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Carpet solution = new Carpet();
        solution.solution(24, 24);
    }
}
