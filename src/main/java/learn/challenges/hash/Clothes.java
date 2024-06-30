package learn.challenges.hash;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Clothes {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }
        for (int cnt : map.values()) {
            answer += --cnt * answer;
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        Clothes solution = new Clothes();
        solution.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
    }
}
