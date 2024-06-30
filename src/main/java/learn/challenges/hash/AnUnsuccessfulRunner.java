package learn.challenges.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class AnUnsuccessfulRunner {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        AnUnsuccessfulRunner solution = new AnUnsuccessfulRunner();
        solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }
}
