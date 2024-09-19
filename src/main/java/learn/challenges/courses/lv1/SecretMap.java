package learn.challenges.courses.lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17681
 * 제목: 비밀 지도
 *
 * Time Complexity: O(n^2): 반복문은 n번 돌고, 각 반복마다 **O(n)**의 연산을 수행하므로 O(n^2).
 * Space Complexity: O(n): answer 배열을 저장하는 데 필요한 공간. 각 문자열은 최대 n 길이
 */
public class SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            // 두 배열의 OR 연산 후 이진수 변환, n 자릿수로 맞추기
            answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]))
                    .replace('1', '#')
                    .replace('0', ' ');
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
        System.out.println("solution = " + solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}));
    }
}
