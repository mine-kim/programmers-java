package learn.challenges.exhaustivesearch.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * 제목: 모의고사
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MathTest {
    public int[] solution(int[] answers) {
        int[] testerA = new int[]{1, 2, 3, 4, 5};
        int[] testerB = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] testerC = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3]; // 각 수포자의 점수 저장
        for (int i = 0; i < answers.length; i++) {
            scores[0] += (answers[i] == testerA[i % 5]) ? 1 : 0;
            scores[1] += (answers[i] == testerB[i % 8]) ? 1 : 0;
            scores[2] += (answers[i] == testerC[i % 10]) ? 1 : 0;
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2])); // 최고 점수

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) { // 최고 점수가 같은 사람 체크
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(o -> o).toArray();
    }

    public static void main(String[] args) {
        MathTest solution = new MathTest();
        solution.solution(new int[]{1,2,3,4,5,2});
        solution.solution(new int[]{1,3,2,4,2});
    }
}
