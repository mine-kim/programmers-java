package learn.challenges.courses.lv2;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * 제목: 오픈 채팅방
 *
 * Time Complexity: O(N), 여기서 N은 record 배열의 길이
 * Space Complexity: O(M), 여기서 M은 고유한 사용자 수
 */
public class OpenChatRoom {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>(); // 사용자 ID와 이름을 저장
        ArrayList<String> messages = new ArrayList<>(); // 결과 메시지를 저장

        // 1. 모든 기록을 처리하여 사용자 ID와 이름을 저장하고, 메시지를 준비
        for (String entry : record) {
            String[] parts = entry.split(" ");
            String action = parts[0];
            String userId = parts[1];

            if (action.equals("Enter") || action.equals("Change")) {
                userMap.put(userId, parts[2]); // 사용자 이름 업데이트
            }

            if (action.equals("Enter")) {
                messages.add(userId + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                messages.add(userId + "님이 나갔습니다.");
            }
        }

        // 2. 결과 배열로 변환
        String[] answer = new String[messages.size()];
        for (int i = 0; i < messages.size(); i++) {
            String[] msgParts = messages.get(i).split("님");
            String userId = msgParts[0];
            String userName = userMap.get(userId); // 최신 사용자 이름 가져오기
            answer[i] = userName + "님" + (messages.get(i).endsWith("들어왔습니다.") ? "이 들어왔습니다." : "이 나갔습니다.");
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChatRoom solution = new OpenChatRoom();
        solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }
}
