package learn.challenges.backtracking;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 * 제목: 삼총사
 *
 * Time Complexity: O(n^3) 명을 선택하는 모든 조합을 확인하는 방식입니다. 배열의 길이가 n일 때, 가능한 모든 조합의 수
 * Space Complexity: O(n) 재귀 호출로 인해 콜 스택이 쌓이므로
 */
public class Trio {
    static int answer = 0;
    public static int solution(int[] number) {
        answer = 0;
        // 백트래킹 시작
        backtrack(number, 0, 0, 0);
        return answer;
    }

    private static void backtrack(int[] number, int idx, int selectedCount, int sum) {
        // 3명을 선택했을 때 합이 0이면 카운트 증가
        if (selectedCount == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }

        // 배열 끝까지 탐색했다면 종료
        if (idx >= number.length) {
            return;
        }

        // 현재 학생 선택하는 경우
        backtrack(number, idx + 1, selectedCount + 1, sum + number[idx]);
        // 현재 학생 선택하지 않는 경우
        backtrack(number, idx + 1, selectedCount, sum);
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println("solution = " + solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println("solution = " + solution(new int[]{-1, 1, -1, 1}));
    }
}
