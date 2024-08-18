package learn.challenges.hash.lv3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * 제목: 베스트앨범
 *
 * Time Complexity: O(n) 두 배열을 한번씩 순회
 * Space Complexity: O(n) map에 최대 N개의 요소가 저장
 */
public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Long> genresSum = new HashMap<>(); // 장르별 총 재생 횟수
        HashMap<String, ArrayList<int[]>> memo = new HashMap<>(); // 장르별 노래 정보
        ArrayList<Integer> list = new ArrayList<>();

        int size = plays.length;
        for(int i = 0; i < size; i++) {
            String name = genres[i];
            int play = plays[i];
            genresSum.put(name, genresSum.getOrDefault(name, 0L) + play); // 장르별 재생 횟수 저장

            if(memo.containsKey(name)) {
                memo.get(name).add(new int[]{i, play});
            } else {
                ArrayList<int []> temp = new ArrayList<>();
                temp.add(new int [] {i, play});
                memo.put(name, temp);
            }
        }

        // 장르별 재생 횟수 내림차순 정렬
        List<Map.Entry<String, Long>> collect = genresSum.entrySet().stream()
                .sorted((o1, o2) -> -(o1.getValue().compareTo(o2.getValue())))
                .toList();

        for (int i = 0; i < genresSum.size(); i++) {
            ArrayList<int[]> temp = memo.get(collect.get(i).getKey());
            // 장르 내에서 재생 횟수 내림차순 정렬
            temp.sort((o1, o2) -> -(o1[1] - o2[1]));
            // 최대 2개만 저장
            for(int j = 0; j < temp.size(); j++){
                if(j == 2) break;
                int [] check = temp.get(j);
                list.add(check[0]);
            }
        }

        int[] answer = new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        BestAlbum solution = new BestAlbum();
        solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        // [4, 1, 3, 0]
    }
}
