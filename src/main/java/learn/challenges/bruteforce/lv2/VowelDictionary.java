package learn.challenges.bruteforce.lv2;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * 제목: 모음사전
 *
 * Time Complexity: O(n) word 문자열을 한 번 순회
 * Space Complexity: O(1) 고정 크기의 배열 및 상수 사용
 *
 */
public class VowelDictionary {
    public int solution(String word) {
        int answer = 0;
        // 가중치 계산
        // 781 = (5^4) + (5^3) + (5^2) + (5^1) + (5^0)
        // 156 = (5^3) + (5^2) + (5^1) + (5^0)
        // 31  = (5^2) + (5^1) + (5^0)
        // 6   = (5^1) + (5^0)
        // 1   = (5^0)
        int[] weight = {781, 156, 31, 6, 1}; // 각 자리별 가중치
        String vowels = "AEIOU";

        for (int i = 0; i < word.length(); i++) {
            answer += weight[i] * vowels.indexOf(word.charAt(i)) + 1; // 가중치 계산 후 1 더하기. 1을 더하는 이유는 빈 문자열 ""도 하나의 단어로 취급하기 때문
        }
        return answer;
    }

    public static void main(String[] args) {
        VowelDictionary solution = new VowelDictionary();
        System.out.println("A = " +  solution.solution("A"));
        System.out.println("AAAAE = " +  solution.solution("AAAAE"));
        System.out.println("AAAE = " +  solution.solution("AAAE"));
        System.out.println("AAAEA = " +  solution.solution("AAAEA"));
        System.out.println("I = " +  solution.solution("I"));
        System.out.println("EIO = " +  solution.solution("EIO"));
    }
}
