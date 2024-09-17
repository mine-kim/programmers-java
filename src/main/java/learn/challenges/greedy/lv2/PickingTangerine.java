package learn.challenges.greedy.lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 * 제목: 귤 고르기
 *
 * Time Complexity: O(n) 귤의 개수
 * Space Complexity: O(m) 귤 종류 수만큼
 */
public class PickingTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> sorted = new ArrayList<>(map.values());
        sorted.sort(Collections.reverseOrder());

        for(int count : sorted){
            total += count;
            answer++;
            if (k >= total) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        PickingTangerine solution = new PickingTangerine();
        solution.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }
}
