package learn.challenges.stackqueue.lv2;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 제목: 다리를 지나는 트럭
 *
 * Time Complexity: O(n) 각 트럭에 대해 큐에 들어가고 나오는 작업이 한 번씩 수행
 * Space Complexity: O(n) 큐
 */
public class TruckCrossingBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue_truck = new LinkedList<>();
        int current_weight = 0;
        int current_second = 0;
        int index = 0;

        // 초 단위로 시뮬레이션
        while (index < truck_weights.length || !queue_truck.isEmpty()) {
            current_second++;

            // 다리에서 나가는 트럭 처리
            if (!queue_truck.isEmpty() && queue_truck.peek()[1] == current_second) {
                current_weight -= queue_truck.poll()[0];
            }

            // 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (index < truck_weights.length && current_weight + truck_weights[index] <= weight) {
                current_weight += truck_weights[index];
                queue_truck.add(new int[]{truck_weights[index], current_second + bridge_length});
                index++;
            }
        }

        return current_second;
    }

    public static void main(String[] args) {
        TruckCrossingBridge solution = new TruckCrossingBridge();
        solution.solution(2, 10, new int[]{7,4,5,6});
    }
}
