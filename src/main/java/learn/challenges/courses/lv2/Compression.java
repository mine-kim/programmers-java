package learn.challenges.courses.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 * 제목: 압축
 *
 * Time Complexity: 입력 문자열을 한 번씩 처리하므로 O(n)
 * Space Complexity: 사전 크기와 결과 리스트의 크기가 입력 길이에 비례하므로 O(n)
 */
public class Compression {
    public static int[] compress(String msg) {
        // Step 1: A~Z로 초기화된 사전을 생성
        Map<String, Integer> dictionary = new HashMap<>();
        int dictSize = 26;
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        String currentString = ""; // 현재 처리 중인 문자열

        // Step 2: 입력 문자열을 하나씩 처리
        for (char c : msg.toCharArray()) {
            String nextString = currentString + c; // 현재 문자열에 다음 글자를 더함
            if (dictionary.containsKey(nextString)) {
                currentString = nextString; // 사전에 있으면, 현재 문자열을 확장
            } else {
                // 사전에 없으면, 현재 문자열의 색인 번호를 출력
                result.add(dictionary.get(currentString));
                // 새로운 문자열을 사전에 추가
                dictionary.put(nextString, ++dictSize);
                // 새로운 현재 문자열로 갱신
                currentString = String.valueOf(c);
            }
        }

        // 마지막 남은 문자열을 처리
        if (!currentString.isEmpty()) {
            result.add(dictionary.get(currentString));
        }

        // Step 3: List<Integer>를 int[] 배열로 변환하여 반환
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output; // 결과 배열 반환
    }

    public static void main(String[] args) {
        String msg = "KAKAO";
        int[] compressed = compress(msg);
        for (int num : compressed) {
            System.out.print(num + " ");
        }
        System.out.println(); // 11 1 27 15

        msg = "TOBEORNOTTOBEORTOBEORNOT";
        compressed = compress(msg);
        for (int num : compressed) {
            System.out.print(num + " ");
        }
        System.out.println(); // 20 15 2 5 15 18 14 15 20 27 29 31 36 30 32 34

        msg = "ABABABABABABABAB";
        compressed = compress(msg);
        for (int num : compressed) {
            System.out.print(num + " ");
        }
        System.out.println(); // 1 2 27 29 28 31 30
    }
}
