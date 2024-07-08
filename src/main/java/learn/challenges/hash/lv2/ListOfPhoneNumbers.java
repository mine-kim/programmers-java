package learn.challenges.hash.lv2;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 제목: 전화번호 목록
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(log n)
 */
public class ListOfPhoneNumbers {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 전화번호를 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) { // 바로 다음 번호와 비교
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ListOfPhoneNumbers solution = new ListOfPhoneNumbers();
        solution.solution(new String[]{"119", "97674223", "1195524421"});
        solution.solution(new String[]{"123","456","789"});
        solution.solution(new String[]{"12","123","1235","567","88"});
    }
}
