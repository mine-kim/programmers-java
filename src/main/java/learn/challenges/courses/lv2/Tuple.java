package learn.challenges.courses.lv2;

import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 * 제목: 튜플
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(N)
 */
public class Tuple {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        //Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple solution = new Tuple();
        //solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"	);
    }
}
