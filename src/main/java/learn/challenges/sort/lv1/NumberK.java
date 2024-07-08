package learn.challenges.sort.lv1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * 제목: K번째수
 *
 * Time Complexity: O(m * n log n)
 * Space Complexity: O(n)
 */
public class NumberK {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] list = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // i~j번째 숫자로 배열 생성
            Arrays.sort(list);
            answer[i] = list[commands[i][2]-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        NumberK solution = new NumberK();
        solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
