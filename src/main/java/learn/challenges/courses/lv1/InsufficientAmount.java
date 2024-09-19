package learn.challenges.courses.lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 * 제목: 부족한 금액 계산하기
 *
 * Time Complexity: O(1): 단순한 산술 연산만 수행
 * Space Complexity: O(1): 상수 공간 사용
 */
public class InsufficientAmount {
    public static long solution(int price, int money, int count) {
        // 등차수열의 합 공식: count * (count + 1) / 2
        return Math.max(((long) price * count * (count + 1) / 2) - money, 0);
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(3, 20, 4));
    }
}
