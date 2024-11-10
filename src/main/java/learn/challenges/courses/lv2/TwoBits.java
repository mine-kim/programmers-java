package learn.challenges.courses.lv2;


import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77885
 * 제목: 2개 이하로 다른 비트
 *
 * Time Complexity: O(n) for문
 * Space Complexity: O(n) 배열 길이
 */
public class TwoBits {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if(num % 2 == 0) {
                answer[i] = num + 1; // 짝수: +1
            } else {
                long bitMask = 1;
                while((num & bitMask) != 0) { // 홀수: 가장 오른쪽에 있는 0 비트를 1로 바꾸고, 바로 오른쪽 비트를 0
                    bitMask <<= 1;
                }
                answer[i] = num + bitMask - (bitMask >> 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TwoBits solution = new TwoBits();
        System.out.println("solution = " + Arrays.toString(solution.solution(new long[]{2, 7})));
        System.out.println("solution = " + Arrays.toString(solution.solution(new long[]{100000,11111})));
    }
}
