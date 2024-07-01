package learn.challenges.exhaustivesearch;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 *
 * Time Complexity: O(√(brown + yellow))
 * Space Complexity: O(1)
 */
public class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int x = 3; x < Math.sqrt(brown + yellow); x++) {
            int y = (brown - x * 2 + 4) / 2;
            if (x * y == brown + yellow) {
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
