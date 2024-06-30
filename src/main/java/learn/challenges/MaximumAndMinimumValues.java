package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class MaximumAndMinimumValues {
    public String solution(String s) {
        String[] list = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<list.length;i++) {
            if(max <= Integer.parseInt(list[i])) max = Integer.parseInt(list[i]);
            if(min >= Integer.parseInt(list[i])) min = Integer.parseInt(list[i]);
        }
        return min + " " + max;
    }

    public static void main(String[] args) {
        MaximumAndMinimumValues solution = new MaximumAndMinimumValues();
        solution.solution("1 2 3 4");
    }
}
