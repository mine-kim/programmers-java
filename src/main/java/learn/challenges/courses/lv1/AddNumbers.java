package learn.challenges.courses.lv1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76501
 * 제목: 음양 더하기
 *
 * Time Complexity: O(n): n은 배열의 길이
 * Space Complexity: O(1): 추가적인 배열이나 자료 구조를 생성하지 않기 때문에
 */
public class AddNumbers {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length ; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("solution = " + solution(new int[]{4,7,12}, new boolean[]{true,false,true}));
    }
}
