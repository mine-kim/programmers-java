package learn.challenges.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
public class TheLargestNumber {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        TheLargestNumber solution = new TheLargestNumber();
        solution.solution(new int[]{6, 10, 2});
        solution.solution(new int[]{3, 30, 34, 5, 9});
    }
}
