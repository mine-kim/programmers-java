package learn.challenges.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 * 제목: 스킬트리
 *
 * Time Complexity:  O(m * n) — 각 스킬 트리에 대해 한 번만 순차적으로 확인하므로 이전 코드와 동일하게 동작합니다.
 * Space Complexity: O(1) — 추가 메모리 사용 없이 인덱스 추적을 위해서만 변수를 사용합니다.
 */
public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            int index = 0;  // skill에서 현재 배워야 할 스킬 인덱스

            for (char c : skill_tree.toCharArray()) {
                if (skill.indexOf(c) == -1) {
                    // 현재 스킬이 순서에 없는 경우 계속 진행
                    continue;
                }

                if (c == skill.charAt(index)) {
                    // 순서에 맞는 경우 인덱스 증가
                    index++;
                } else {
                    // 순서에 맞지 않으면 해당 스킬트리는 유효하지 않음
                    break;
                }
            }

            // 스킬트리가 끝까지 유효했다면 answer 증가
            if (index == skill.length() || skill_tree.indexOf(skill.charAt(index)) == -1) {
                answer++;
            }
        }

        return answer;
    }

    /**
     *
     * Time Complexity:  O(m * n + k) m은 skill_trees 배열의 길이, n은 각 스킬 트리의 최대 길이, k는 skill의 길이
     * Space Complexity: O(k + n) k는 skill의 길이, n은 각 스킬 트리의 최대 길이
     */
    public int solution2(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        Set<Character> set = new HashSet<>();
        for (char c : skill.toCharArray()) {
            set.add(c);
        }

        //스킬트리 체크
        for (int i = 0; i < skill_trees.length; i++) {
            String diff = skill;
            char[] chars = skill_trees[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (set.contains(chars[j])) {
                    if(diff.charAt(0) != chars[j]) {
                        answer--;
                        break;
                    } else {
                        diff = diff.substring(1);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTree solution = new SkillTree();
        System.out.println("solution = " + solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
