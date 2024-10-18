package learn.challenges.bfs.lv3;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * 제목: 단어 변환
 *
 * Time Complexity: O(n^2 * L)  BFS의 각 단계에서 최대 n개의 단어 탐색, inNext 함수는 단어길이 L만큼
 * Space Complexity: O(n * L) 큐에 저장되는 각 단어의 길이는 L이므로, 큐에 저장된 모든 문자열의 공간 복잡도
 *
 */
public class WordConversion {
    public int solution(String begin, String target, String[] words) {
        // words가 target을 포함하고 있는지 확인. 포함하지 않으면 0 반환
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // 방문 체크를 위한 배열
        boolean[] visited = new boolean[words.length];

        // 큐를 사용하여 BFS 구현
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> steps = new LinkedList<>();
        queue.offer(begin);
        steps.offer(0);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentStep = steps.poll();

            // 목표 단어와 일치하는지 확인
            if (currentWord.equals(target)) {
                return currentStep;
            }

            // words 목록에서 변환 가능한 단어들을 찾아 큐에 삽입
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && inNext(currentWord, words[i])) {
                    queue.offer(words[i]);
                    steps.offer(currentStep + 1);
                    visited[i] = true; // 해당 단어를 방문했음을 표시
                }
            }
        }

        return 0; // 변환할 수 없는 경우
    }

    // 두 단어가 한 글자 차이인지 확인하는 함수
    private boolean inNext(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        WordConversion solution = new WordConversion();
        solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
    }
}
