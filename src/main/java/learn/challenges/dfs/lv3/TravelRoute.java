package learn.challenges.bfs.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * 문제: 여행 경로
 *
 * Time Complexity: O(n * m) BFS는 각 노드를 한 번씩 탐색. n: 행 개수, m: 열 개수
 * Space Complexity: O(n * m) 큐의 최대 크기는 전체 맵의 크기와 같으므로
 *
 */
public class TravelRoute {
    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        // 티켓을 정렬한다
        Arrays.sort(tickets, Comparator.comparing((String[] a) -> a[0])
                .thenComparing(a -> a[1]));

        boolean[] visited = new boolean[tickets.length];

        // 티켓별로 돌아가면서 1번으로 지정한다.
        for (int i = 0; i < tickets.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while(!queue.isEmpty()) {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}}));
        System.out.println("solution = " + solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
    }
}
