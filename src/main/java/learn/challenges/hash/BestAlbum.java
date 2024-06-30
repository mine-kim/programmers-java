package learn.challenges.hash;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Long> genresSum = new HashMap<>();
        HashMap<String, ArrayList<int[]>> memo = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int size = plays.length;
        for(int i = 0; i < size; i++) {
            String name = genres[i];
            int play = plays[i];
            genresSum.put(name, genresSum.getOrDefault(name, 0L) + play);
            if(memo.containsKey(name)) {
                memo.get(name).add(new int[]{i, play});
            } else {
                ArrayList<int []> temp = new ArrayList<>();
                temp.add(new int [] {i, play});
                memo.put(name, temp);
            }
        }
        List<Map.Entry<String, Long>> collect = genresSum.entrySet().stream().sorted((o1, o2) -> {
            return -(o1.getValue().compareTo(o2.getValue()));
        }).collect(Collectors.toList());

        for (int i = 0; i < genresSum.size(); i++) {
            ArrayList<int[]> temp = memo.get(collect.get(i).getKey());
            Collections.sort(temp, (o1, o2) -> {
                return -(o1[1] - o2[1]);
            });
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
        //"classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
    }
}
