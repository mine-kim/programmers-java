package learn.challenges.sort.lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * 제목: 가장 큰 수
 *
 * Time Complexity: O(n log n) 정렬
 * Space Complexity: O(n) 배열
 */
public class TheLargestNumber {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        // 문자열 비교를 위한 Comparator 정의, 내림차순 정렬
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
        solution.solution(new int[]{6, 0, 2});
        solution.solution(new int[]{3, 30, 34, 5, 9});
    }
}
