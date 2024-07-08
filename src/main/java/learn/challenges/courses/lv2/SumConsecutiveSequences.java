package learn.challenges.courses.lv2;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 제목: 연속 부분 수열 합의 개수
 *
 * Time Complexity: O(N^2) 이중 반복문
 * Space Complexity: O(N^2) 최악의 경우 모든 부분합이 다를 경우
 */
public class SumConsecutiveSequences {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i <= elements.length; i++)
        {
            for(int j = 0; j <= elements.length; j++)
            {
                int sum = 0;
                for(int k = j; k < j+i; k++)
                {
                    sum += elements[k%elements.length];
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }

    public int solution2(int[] elements) {
        int n = elements.length;
        HashSet<Integer> sums = new HashSet<>(); // 중복 제거를 위한 HashSet

        // 모든 시작점과 길이에 대한 부분 합 계산
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int length = 1; length <= n; length++) {
                sum = (sum + elements[(start + length - 1) % n]);
                sums.add(sum);
            }
        }

        return sums.size(); // 중복 제거된 부분 합 개수 반환
    }

    public static void main(String[] args) {
        SumConsecutiveSequences solution = new SumConsecutiveSequences();
        solution.solution(new int[]{7,9,1,1,4});
    }
}
