package learn.challenges.courses.lv2;

import java.util.HashSet;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * 제목: 영어 끝말잇기
 *
 * Time Complexity: O(n) for문
 * Space Complexity: O(n) HashSet
 */
public class WordChain {
    public int[] solution(int n, String[] words) {
        HashSet<String> usedWords = new HashSet<>();
        char lastChar = words[0].charAt(words[0].length() - 1); // 첫 단어 마지막 글자

        for (int i = 1; i < words.length; i++) {
            int person = (i % n) + 1; // 현재 차례 사람 번호
            int turn = (i / n) + 1; // 현재 차례

            String word = words[i];
            if (usedWords.contains(word) || word.charAt(0) != lastChar) { // 탈락 조건
                return new int[]{person, turn};
            }

            usedWords.add(word); // 사용한 단어 추가
            lastChar = word.charAt(word.length() - 1); // 마지막 글자 갱신
        }

        return new int[]{0, 0}; // 탈락자가 없는 경우
    }

    public static void main(String[] args) {
        WordChain solution = new WordChain();
        solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
}
