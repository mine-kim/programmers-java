package learn.challenges.sort;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 *
 * Time Complexity: O(m * n log n)
 * Space Complexity: O(n)
 */
public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;
        for (int i = citations.length-1; i >= 0; i--) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                hIndex = h;
            } else {
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        HIndex solution = new HIndex();
        solution.solution(new int[]{3});
        solution.solution(new int[]{3, 0, 6, 1, 5});
        solution.solution(new int[]{5, 6, 7, 8, 9});
    }
}
