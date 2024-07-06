package learn.challenges.exhaustivesearch;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 */
public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        for(int[] size : sizes) {
            x = Math.max(x, Math.min(size[0], size[1])); // 명함의 더 긴 변을 가로로 간주
            y = Math.max(y, Math.max(size[0], size[1])); // 명함의 더 짧은 변을 세로로 간주
        }
        return x * y; // 지갑 크기
    }

    public static void main(String[] args) {
        MinimumRectangle solution = new MinimumRectangle();
        solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
    }
}
