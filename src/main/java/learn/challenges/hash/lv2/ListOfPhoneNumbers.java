package learn.challenges.hash.lv2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * 제목: 전화번호 목록
 *
 * Time Complexity: O(n * m) (여기서 n은 전화번호 개수, m은 각 전화번호의 평균 길이)
 * Space Complexity: O(n) (모든 전화번호를 해시맵에 저장하는 데 필요한 공간)
 */
public class ListOfPhoneNumbers {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();

        // 모든 전화번호를 해시맵에 저장
        for (String number : phone_book) {
            map.put(number, true);
        }

        // 각 전화번호의 접두사가 해시맵에 있는지 확인
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (map.containsKey(number.substring(0, i))) {
                    return false;
                }
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
