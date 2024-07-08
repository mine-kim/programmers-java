package learn.challenges.heap.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * 제목: 디스크 컨트롤러
 *
 * Time Complexity: O(n log n) 우선순위 큐, 정렬
 * Space Complexity: O(n) 고정 크기의 배열 및 우선순위 큐
 */
public class DiskController {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0])); // 요청 시간 기준 오름차순 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); // 작업 시간 기준 오름차순 우선순위 큐

        int time = 0; // 현재 시간
        int totalTime = 0; // 총 작업 시간
        int jobCount = 0; // 완료된 작업 수

        int i = 0; // jobs 배열 인덱스
        while (jobCount < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= time) { // 현재 시간에 요청된 작업들을 우선순위 큐에 추가
                pq.offer(jobs[i++]);
            }

            if (!pq.isEmpty()) { // 우선순위 큐에 작업이 있다면
                int[] job = pq.poll();
                time += job[1]; // 작업 시간만큼 시간 증가
                totalTime += time - job[0]; // 작업 요청부터 종료까지 걸린 시간 누적
                jobCount++;
            } else { // 우선순위 큐에 작업이 없다면
                time = jobs[i][0]; // 다음 작업 요청 시간으로 이동
            }
        }

        return totalTime / jobs.length; // 평균 작업 시간 계산
    }

    public static void main(String[] args) {
        DiskController solution = new DiskController();
        solution.solution(new int[][]{{0, 3},{1, 9},{2, 6}});
    }
}
