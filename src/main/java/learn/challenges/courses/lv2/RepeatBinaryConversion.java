package learn.challenges.courses.lv2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * 제목: 이진 변환 반복하기
 * Time Complexity: O(logN) 반복
 * Space Complexity: O(logN) 배열, 문자열 변환
 */
public class RepeatBinaryConversion {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int temp;
        while(!s.equals("1")) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);

            answer[0]++;
            answer[1] -= temp;
        }
        return answer;
    }

    public static void main(String[] args) {
        RepeatBinaryConversion solution = new RepeatBinaryConversion();
        solution.solution("110010101001");
    }
}
