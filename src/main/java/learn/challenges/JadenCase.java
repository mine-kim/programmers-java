package learn.challenges;

import java.util.Locale;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 *
 * Time Complexity: O(n) 반복문
 * Space Complexity: O(n) StringBuilder
 */
public class JadenCase {
    public String solution(String s) {
        boolean isFisrt = true;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isFisrt = true;
            } else {
                if (isFisrt) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isFisrt = false;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JadenCase solution = new JadenCase();
        solution.solution("  for the what 1what  ");
    }
}
