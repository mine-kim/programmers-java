package learn.challenges.twopointers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 제목: 연속된 부분 수열의 합
 *
 * Time Complexity: O(n) 각 포인터가 배열을 최대 한번씩 탐색
 * Space Complexity: O(1)
 */
public class SumOfSequences {
    public static int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = sequence[0];
        int[] answer = {-1, -1}; // 결과 저장할 배열
        int minLength = Integer.MAX_VALUE;

        while (right < sequence.length) {
            if(sum == k) {
                if(right - left < minLength) {
                    answer[0] = left;
                    answer[1] = right;
                    minLength = right - left;
                }
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length) sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution(new int[]{1, 2, 3, 4, 5}, 7) = " + solution(new int[]{1, 2, 3, 4, 5}, 7));
        System.out.println("solution(new int[]{1, 2, 3, 4, 5}, 7) = " + solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5));
        System.out.println("solution(new int[]{1, 2, 3, 4, 5}, 7) = " + solution(new int[]{2, 2, 2, 2, 2}, 6));
    }
}
