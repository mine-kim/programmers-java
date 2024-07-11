package learn.challenges.courses.lv2;

import java.util.*;
import java.util.regex.Pattern;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * 제목: [1차]뉴스 크러스터링
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class NewsClustering {
    public int solution(String str1, String str2) {
        str1 =  str1.toUpperCase(Locale.ROOT);
        str2 =  str2.toUpperCase(Locale.ROOT);

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < str1.length()-1; i++) {
           String temp = str1.substring(i, i+2);
           if (Pattern.matches("^[A-Z]*$", temp)) {
               list1.add(temp);
           }
        }

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < str2.length()-1; i++) {
            String temp = str2.substring(i, i+2);
            if (Pattern.matches("^[A-Z]*$", temp)) {
                list2.add(temp);
            }
        }

        int union =  union(list1, list2);
        int intersection = intersection(list1, list2);

        double answer = 65536;
        if (union - intersection > 0) {
            answer = ((double) intersection / (union - intersection)) * 65536;
        }
        return (int) answer;
    }

    private int intersection(List<String> s1, List<String> s2) {
        List<String> result = new ArrayList<>();

        for(String value : s1){
            if(s2.contains(value)){
                result.add(value);
                s2.remove(value);
            }
        }

        return result.size();
    }

    private int union(List<String> s1, List<String> s2) {
        ArrayList<String> result = new ArrayList<>(s1);
        result.addAll(s2);
        return result.size();
    }


    public static void main(String[] args) {
        NewsClustering solution = new NewsClustering();
        //solution.solution("aa1+aa2", "AAAA12");
        //solution.solution("FRANCE",	"french");
        solution.solution("aaabbcccccccc",	"aaaabbcccc"); // 40329
    }
}
