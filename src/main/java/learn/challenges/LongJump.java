package learn.challenges;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 *
 * Time Complexity: O(n) n번 반복
 * Space Complexity: O(n) 배열의 크기
 */
public class LongJump {
    long answer = 0;
    public long solution(int n) {
        int[] list = new int[n+2];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < n+2; i++) {
            list[i] = (list[i -1] + list[i -2]) % 1234567;
        }
        return list[n+1];
    }

    public static void main(String[] args) {
        LongJump solution = new LongJump();
        solution.solution(4);
    }
}
