package learn.challenges.courses.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * 제목: 이중우선순위큐
 *
 * Time Complexity: 최악의 경우 O(n * m) (여기서 n은 operations의 길이, m은 리스트의 최대 크기)
 * Space Complexity: O(n) (리스트에 저장된 최대 정수 개수)
 */
public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : operations) {
            String[] operation = s.split(" ");
            if (operation[0].equals("I")) {
                list.add(Integer.parseInt(operation[1]));
            } else {
                if (list.isEmpty()) continue;
                if (operation[1].equals("1")){
                    list.remove(Collections.max(list));
                } else {
                    list.remove(Collections.min(list));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{Collections.max(list), Collections.min(list)};
        }
    }

    public static void main(String[] args) {
        DoublePriorityQueue solution = new DoublePriorityQueue();
        System.out.println(Arrays.toString(solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}
