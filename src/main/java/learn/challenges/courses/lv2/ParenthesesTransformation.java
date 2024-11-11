package learn.challenges.courses.lv2;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60058
 * 제목: 괄호 변환
 *
 * Time Complexity: O(n^2) 재귀적으로 문자열을 분할하고 각 단계에서 문자열을 수정하는 과정이 중첩되어 최악의 경우 O(n^2)
 * Space Complexity: O(n^2) 재귀 호출 스택과 각 단계에서 생성되는 문자열이 중첩되며 최악의 경우 O(n^2)의 공간
 */

public class ParenthesesTransformation {
    public String solution(String p) {
        if ("".equals(p) || checkYn(p)) return p;
        return dfs(p);
    }

    public String dfs(String p) {
        System.out.println("p = " + p);
        if (checkYn(p)) return p;

        int cnt = 0;
        String u = "";
        String v = "";

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (checkYn(u)) {
            return u + dfs(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(dfs(v)).append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
            return sb.toString();
        }
    }

    // 올바른 괄호 문자열 체크
    public boolean checkYn(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        ParenthesesTransformation solution = new ParenthesesTransformation();
        System.out.println("solution = " + solution.solution("(()())()"));
        System.out.println("solution = " + solution.solution(")("));
        System.out.println("solution = " + solution.solution("()))((()"));
    }
}
