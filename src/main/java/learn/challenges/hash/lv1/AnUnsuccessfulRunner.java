package learn.challenges.hash.lv1;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * 제목: 완주하지 못한 선수
 *
 * Time Complexity: O(n) 두 배열을 한번씩 순회
 * Space Complexity: O(n) map에 최대 N개의 요소가 저장
 */
public class AnUnsuccessfulRunner {
    public String solution(String[] participant, String[] completion) {
        String answer = ""; // 미완주자 1명
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1); // 참가자 이름과 등장 횟수 저장
        for (String player : completion) hm.put(player, hm.get(player) - 1); // 완주자 이름 등장 횟수 감소

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer; // 완주하지 못한 선수 이름 반환
    }

    public static void main(String[] args) {
        AnUnsuccessfulRunner solution = new AnUnsuccessfulRunner();
        solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }
}
