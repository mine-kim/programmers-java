package learn.challenges.courses.lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12941
 * 제목: 최솟값만들기
 *
 * Time Complexity: O(n log n) 정렬
 * Space Complexity: O(1) 또는 O(log N) 정렬 과정에서 추가적인 공간이 필요할수 있음
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
