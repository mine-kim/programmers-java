package learn.challenges.courses.lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12947
 * 제목: 하샤드 수
 *
 * Time Complexity: O(log x) 숫자의 자릿수는 최대 log₁₀x
 * Space Complexity: O(1) 변수 2개 사용
 */
public class HarshadNumber {
    public boolean solution(int x) {
        int sumOfDigits = 0;
        int temp = x;

        while (temp > 0) {
            sumOfDigits += temp % 10; // 각 자릿수 추출 및 합 계산
            temp /= 10;
        }

        return x % sumOfDigits == 0; // 하샤드 수 판별
    }

    public boolean solution2(int x) {
        boolean answer = false;
        int sum = 0;
        for (String str : String.valueOf(x).split("")) {
            sum += Integer.parseInt(str);
        }
        if (x % sum == 0) answer = true;
        return answer;
    }

    public static void main(String[] args) {
        HarshadNumber solution = new HarshadNumber();
        solution.solution(12);
    }
}
