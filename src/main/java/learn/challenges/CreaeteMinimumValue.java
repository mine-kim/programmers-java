package learn.challenges;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class CreaeteMinimumValue {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        int length = A.length - 1;
        for (int i=0; i <= length; i++) {
            sum += A[i]*B[length-i];
        }
        return sum;
    }

    public static void main(String[] args) {
        CreaeteMinimumValue solution = new CreaeteMinimumValue();
        solution.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
    }
}
