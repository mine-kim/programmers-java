package learn.challenges.courses.lv2;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 * 제목: 방문 길이
 *
 * Time Complexity: O(n): 주어진 명령어의 길이(n)에 비례하는 반복문을 사용하여 경로를 기록
 * Space Complexity: O(n): Set 자료구조에 중복되지 않는 경로를 저장
 */
public class TheLengthOfVisit {
    public static int solution(String dirs) {
        Set<String> pathSet = new HashSet<>();
        int x = 0, y = 0;  // 캐릭터의 현재 좌표

        for (char dir : dirs.toCharArray()) {
            int newX = x, newY = y;

            // 명령어에 따라 이동 좌표 결정
            if (dir == 'U' && y < 5) newY++;  // 위로 이동
            else if (dir == 'D' && y > -5) newY--;  // 아래로 이동
            else if (dir == 'R' && x < 5) newX++;  // 오른쪽으로 이동
            else if (dir == 'L' && x > -5) newX--;  // 왼쪽으로 이동

            // 유효한 이동인지 확인 (경계를 벗어나지 않았는지)
            if (newX != x || newY != y) {
                // 경로를 문자열로 저장
                String path1 = x + "" + y + "" + newX + "" + newY;  // 현재 -> 새로운 위치
                String path2 = newX + "" + newY + "" + x + "" + y;  // 새로운 위치 -> 현재 위치 (반대 방향)

                // Set에 경로 저장 (중복 방지)
                pathSet.add(path1);
                pathSet.add(path2);

                // 좌표 갱신
                x = newX;
                y = newY;
            }
        }

        return pathSet.size() / 2;
    }

    public static void main(String[] args) {
        System.out.println("Result 1: " + solution("ULURRDLLU"));  // Expected output: 7
        System.out.println("Result 2: " + solution("LULLLLLLU"));  // Expected output: 7
        System.out.println("Result 3: " + solution("UUUUUUUUU"));  // Expected output: 1
    }
}
