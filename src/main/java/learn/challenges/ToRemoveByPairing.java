package learn.challenges;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class ToRemoveByPairing {
    public int solution(String s) {
        if(s.length() < 2) return 0;
        String[] split = s.split("");
        Deque<String> stack = new LinkedList<String>();
        for (String str : split) {
            if(!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        ToRemoveByPairing solution = new ToRemoveByPairing();
        solution.solution("baba");
    }
}
