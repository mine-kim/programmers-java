package learn.challenges.hash.lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * 제목: 의상
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        // 의상 종류별 개수 세기
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        for (int cnt : map.values()) {
            answer *= (cnt + 1); // 해당 종류의 의상을 입거나 안 입는 경우 (+1)
        }
        return answer - 1; // 아무것도 안 입는 경우 제외
    }

    public static void main(String[] args) {
        Clothes solution = new Clothes();
        solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"smoky_makeup", "face"}});
    }
}
