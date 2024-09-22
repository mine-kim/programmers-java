package learn.challenges.hash;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * 제목: 롤케이크 자르기
 *
 * Time Complexity: O(n) 반복문
 * Space Complexity: O(n) HashMap, HashSet
 */
public class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1); // 각 숫자별로 갯수 저장하기
        }

        Set<Integer> setA = new HashSet<Integer>();
        for (int i = 0; i < topping.length; i++) {
            setA.add(topping[i]);
            int temp = map.getOrDefault(topping[i], 0);
            if (temp > 1)
                map.put(topping[i], map.getOrDefault(topping[i], 0) - 1);
            else
                map.remove(topping[i]);

            if (setA.size()==map.size()) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CuttingRollCake solution = new CuttingRollCake();
        solution.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
        solution.solution(new int[]{1, 2, 3, 1, 4});
    }
}
