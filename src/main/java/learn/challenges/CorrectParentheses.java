package learn.challenges;

/**
 *
 */
public class CorrectParentheses {
    boolean solution(String s) {
        String[] list = s.split("");

        if(!list[0].equals("(")) return false;

        int index = 0;
        for(String str : list) {
            if(index < 0) return false;
            if (str.equals("(")) {
                ++index;
            } else if (str.equals(")")) {
                --index;
            }
        }

        return index == 0;
    }

    public static void main(String[] args) {
        CorrectParentheses solution = new CorrectParentheses();
        solution.solution("(()(");
    }
}
