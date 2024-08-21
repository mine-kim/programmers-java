package learn.challenges.courses.lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * 제목: 영어 끝말잇기
 *
 *
 * Time Complexity: 단어 배열을 순차적으로 검사하며 각 단어에 대해 O(1) 시간 안에 중복 여부를 검사합니다. 따라서 전체 시간 복잡도는 O(m)
 * Space Complexity: 사용된 단어들을 HashSet에 저장하므로 O(m)
 */
public class Shiritori {

    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        String prev = words[0];
        used.add(prev);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (word.charAt(0) != prev.charAt(prev.length() - 1) || !used.add(word)) {
                int a = (i % n) + 1;
                int d = (i / n) + 1;
                return new int[]{a, d};
            }
            prev = word;
        }

        return new int[]{0, 0};
    }

    /**
     * Time Complexity: Queue에서 contains 메서드는 O(m)의 시간이 소요. 최악의 경우 모든 단어에 대해 중복 검사를 수행해야 하므로, 전체 시간 복잡도는 O(m^2)
     * Space Complexity: 큐에 모든 단어를 저장할 수 있으므로 공간 복잡도는 O(m)
     */
    public int[] solution1(int n, String[] words) {
        int[] answer = {0, 0};
        Queue<String> used = new LinkedList<>();

        String prev = " " + words[0].substring(0,1);
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if(!prev.substring(prev.length()-1).equals(word.substring(0,1)) ||
                    (!used.isEmpty() && used.contains(word))) {
                int a = (i+1)%n == 0 ? n : (i+1)%n;
                int d = (i+1)/n+(i+1)%n;
                return new int[]{a, d};
            }
            prev = word;
            used.offer(word);
        }

        return answer;
    }

    public static void main(String[] args) {
        Shiritori solution = new Shiritori();
        solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
}
