package learn.challenges.courses.lv2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 * 제목: [1차]캐시
 *
 * Time Complexity: O(N) LinkedHashMap
 * Space Complexity: O(cacheSize) 맵의 최대 크기
 */
public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;

        if (cacheSize == 0) {
            return cities.length * 5; // 캐시 크기가 0이면 모두 cache miss
        }

        Map<String, Integer> cache = new LinkedHashMap<>(cacheSize, 0.75f, true);

        for (String city : cities) {
            String cityLower = city.toLowerCase();
            if (cache.containsKey(cityLower)) {
                totalTime += 1;
            } else {
                totalTime += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(cache.keySet().iterator().next());
                }
            }
            cache.put(cityLower, 0);
        }
        return totalTime;
    }

    public static void main(String[] args) {
        Cache solution = new Cache();
        //solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
        //solution.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
        solution.solution(0, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
        solution.solution(3, new String[]{});
    }
}
