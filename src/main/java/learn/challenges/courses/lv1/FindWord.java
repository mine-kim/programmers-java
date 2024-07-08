package learn.challenges.courses.lv1;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12919
 * 제목: 서울에서 김서방 찾기
 *
 * Time Complexity: O(n) 반복문
 * Space Complexity: O(1)
 */
public class FindWord {
    public String solution(String[] seoul) {
        for(int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) return "김서방은 "+i+"에 있다";
        }
        return "";
    }

    public String solution2(String[] seoul) {
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + x + "에 있다";
    }

    public static void main(String[] args) {
        FindWord solution = new FindWord();
        solution.solution(new String[]{"Jane", "Kim"});
    }
}
