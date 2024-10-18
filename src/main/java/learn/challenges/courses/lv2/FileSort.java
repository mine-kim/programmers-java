package learn.challenges.courses.lv2;


import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 * 제목: 파일명 정렬
 *
 * Time Complexity: O(N), 여기서 N은 record 배열의 길이
 * Space Complexity: O(M), 여기서 M은 고유한 사용자 수
 */
public class FileSort {
    public String[] solution(String[] files) {
        Arrays.sort(files, (file1, file2) -> {
            String[] parts1 = splitFileName(file1);
            String[] parts2 = splitFileName(file2);

            // HEAD 비교 (대소문자 구분 없이)
            int headComparison = parts1[0].toLowerCase().compareTo(parts2[0].toLowerCase());
            if (headComparison != 0) return headComparison;

            // NUMBER 비교
            return Integer.compare(Integer.parseInt(parts1[1]), Integer.parseInt(parts2[1]));
        });

        return files;
    }

    private String[] splitFileName(String file) {
        String head = "";
        String number = "";
        int i = 0;

        // HEAD 부분 찾기
        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i++);
        }

        // NUMBER 부분 찾기
        while (i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i++);
        }

        return new String[]{head, number};
    }

    public static void main(String[] args) {
        FileSort sort = new FileSort();

        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(sort.solution(files1)));

        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(Arrays.toString(sort.solution(files2)));
    }
}
